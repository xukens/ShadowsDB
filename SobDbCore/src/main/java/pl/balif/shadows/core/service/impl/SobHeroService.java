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
import pl.balif.shadows.core.domain.action.command.HeroAddLevel;
import pl.balif.shadows.core.domain.action.command.HeroAddSkills;
import pl.balif.shadows.core.domain.action.command.core.HeroLog;
import pl.balif.shadows.core.domain.action.template.HeroAddSkillsTemplate;
import pl.balif.shadows.core.domain.embeddable.Skills;
import pl.balif.shadows.core.dto.form.HeroForm;
import pl.balif.shadows.core.repositorie.HeroClassRepository;
import pl.balif.shadows.core.repositorie.HeroRepository;

import java.util.List;
import pl.balif.shadows.core.repositorie.command.HeroLogRepository;
import pl.balif.shadows.core.repositorie.command.HeroUpdateRepository;

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
    private final HeroLogRepository heroLogRepository;
    private final HeroUpdateRepository heroUpdateRepository;

    @Autowired
    public SobHeroService(HeroRepository heroRepository, HeroClassRepository heroClassRepository, ConversionService conversionService, HeroLogRepository heroLogRepository, HeroUpdateRepository heroUpdateRepository) {
        this.heroRepository = heroRepository;
        this.heroClassRepository = heroClassRepository;
        this.conversionService = conversionService;
        this.heroLogRepository = heroLogRepository;
        this.heroUpdateRepository = heroUpdateRepository;
    }

    @Override
    public List<HeroForm> getHeroes() {
        List<Hero> heroList = (List<Hero>) heroRepository.findAll();
//        heroLogRepository.findOne(1L).getMacro().getCommands().toString();
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
        HeroLog heroLog = new HeroLog(hero);
        heroLog=heroLogRepository.save(heroLog);
        HeroAddSkillsTemplate temp = new HeroAddSkillsTemplate(new Skills(1,2,3,4,5,6,7));
        heroLog.executeCommand(temp);
//        HeroAddSkills hsl = new HeroAddSkills();
//        heroLog.executeNew(hsl);
//        heroLog.executeNew(new HeroAddLevel());
//        heroLog.executeNew(new HeroAddSkills());
//        HeroAddLevel hal = new HeroAddLevel();
//        hal.setEntirety(heroLog.getMacro());
//        hal= heroUpdateRepository.save(hal);
//        heroLog.getMacro().getCommands().add(hal);
        return hero.getId();
    }

    private Map<Item, Integer> mapToItemQuantityMap(List<Item> items) {
        return items.stream().collect(Collectors
                .groupingBy(item -> item, Collectors.reducing(0, item -> 1, Integer::sum)));
    }

}
