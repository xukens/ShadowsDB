package pl.balif.shadows.core.service.impl;

import com.google.common.collect.Lists;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.balif.shadows.core.converter.ConversionService;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.HeroClass;
import pl.balif.shadows.core.domain.Item;
import pl.balif.shadows.core.dto.form.HeroForm;
import pl.balif.shadows.core.repositorie.HeroClassRepository;
import pl.balif.shadows.core.repositorie.HeroRepository;

import java.util.List;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkArgument;
import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Service
@Transactional
public class SobHeroService implements pl.balif.shadows.core.service.SobHeroService {

    private final HeroRepository heroRepository;
    private final HeroClassRepository heroClassRepository;
    private final ConversionService conversionService;

    @Autowired
    public SobHeroService(HeroRepository heroRepository, HeroClassRepository heroClassRepository, ConversionService conversionService) {
        this.heroRepository = heroRepository;
        this.heroClassRepository = heroClassRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<HeroForm> getHeroes() {
        List<Hero> heroList = (List<Hero>) heroRepository.findAll();
        return conversionService.convert(heroList, HeroForm.class);
    }

    @Override
    public HeroForm getHero(Long id) {
        checkNotNull(id, "20160529:142345");
        return conversionService.convert(heroRepository.getOne(id), HeroForm.class);
    }

    @Override
    public Long createNewHero(Long heroClassId, String heroName) {
        checkNotNull(heroClassId, "20160529:205633");
        HeroClass heroClass = heroClassRepository.getOne(heroClassId);
        Hero hero = new Hero();
        hero.setHeroClass(heroClass);
        hero.setName(heroName);
        hero.setHeroStats(heroClass.getHeroStats());
        hero.setSkills(heroClass.getSkills());
        hero.setAbilities(Lists.newArrayList(heroClass.getAbilities()));
        hero.setKeywords(Lists.newArrayList(heroClass.getKeywords()));
        hero.setItems(mapToItemQuantityMap(heroClass.getItems()));
        hero = heroRepository.save(hero);
        return hero.getId();
    }

    private Map<Item, Integer> mapToItemQuantityMap(List<Item> items) {
        return items.stream().collect(Collectors
                .groupingBy(item -> item, Collectors.reducing(0, item -> 1, Integer::sum)));
    }

}
