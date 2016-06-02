package pl.balif.shadows.core.bootstrap;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.Ability;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.HeroClass;
import pl.balif.shadows.core.domain.Item;
import pl.balif.shadows.core.domain.Keyword;
import pl.balif.shadows.core.domain.embeddable.HeroStats;
import pl.balif.shadows.core.domain.embeddable.Skills;
import pl.balif.shadows.core.repositorie.AbilityRepository;
import pl.balif.shadows.core.repositorie.HeroClassRepository;
import pl.balif.shadows.core.repositorie.HeroRepository;
import pl.balif.shadows.core.repositorie.ItemRepository;
import pl.balif.shadows.core.repositorie.KeywordRepository;
import pl.balif.shadows.core.repositorie.command.HeroLogRepository;
import pl.balif.shadows.core.service.SobHeroService;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public class DevData implements ApplicationListener<ContextRefreshedEvent> {

    private final HeroRepository heroRepository;
    private final AbilityRepository abilityRepository;
    private final KeywordRepository keywordRepository;
    private final HeroClassRepository heroClassRepository;
    private final ItemRepository itemRepository;
    private final SobHeroService sobHeroService;
    private final HeroLogRepository heroLogRepository;

    @Autowired
    public DevData(HeroRepository heroRepository, AbilityRepository abilityRepository, KeywordRepository keywordRepository, HeroClassRepository heroClassRepository, ItemRepository itemRepository, SobHeroService sobHeroService, HeroLogRepository heroLogRepository) {
        this.heroRepository = heroRepository;
        this.abilityRepository = abilityRepository;
        this.keywordRepository = keywordRepository;
        this.heroClassRepository = heroClassRepository;
        this.itemRepository = itemRepository;
        this.sobHeroService = sobHeroService;
        this.heroLogRepository = heroLogRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Keyword keyword = createKeyword("Cowboy");
        Ability ability = createAbility("runner");
        Keyword keywordPriest = createKeyword("Priest");
        Ability abilityAim = createAbility("aimed shoot");
        HeroClass hc = createHeroClass();

        Long h = sobHeroService.createNewHero(hc.getId(), "Flamaster Nun");
        Hero hero = heroRepository.getOne(h);

        sobHeroService.getHeroes();
//        Hero hero = createHero("Flamaster", 5, 10, 4, 4, 10, 4, 4, 2, 2, new Keyword[]{keyword, keywordPriest}, new Ability[]{ability}, 4, 4, 4, 4, 4, 4);
//        Hero heroMagik = createHero("Magik", 5, 10, 4, 4, 10, 4, 4, 2, 2, new Keyword[]{keywordPriest}, new Ability[]{abilityAim, ability}, 5, 2, 5, 2, 4, 3);
    }

    public HeroClass createHeroClass() {
        HeroClass hc = new HeroClass();
        hc.setName("Nun");
        hc.setSkills(createSkills(1, 2, 4, 3, 3, 2, 2));
        hc.setHeroStats(createHeroStats(5, 4, 2, 2, 12, 10, 5, 3));
        hc.setAbilities(generateAbilities("Nun", 3));
        hc.setKeywords(generateKeywords("Nun", 3));
        hc.setItems(generateItem("Gun",3));
        hc.getItems().addAll(generateItem("Gun",2));
        hc = heroClassRepository.save(hc);
        return heroClassRepository.save(hc);
    }

    private HeroStats createHeroStats(Integer toHitRange, Integer toHitMelee,
                                      Integer combat, Integer maxGrit,
                                      Integer maxHealth, Integer maxSanity,
                                      Integer defendse, Integer willpower) {
        HeroStats heroStats = new HeroStats();
        heroStats.setMaxHealth(maxHealth);
        heroStats.setDefense(defendse);
        heroStats.setWillpower(willpower);
        heroStats.setMaxSanity(maxSanity);
        heroStats.setToHitRange(toHitRange);
        heroStats.setToHitMelee(toHitMelee);
        heroStats.setCombat(combat);
        heroStats.setMaxGrit(maxGrit);
        return heroStats;
    }

    private Hero createHero(String name, HeroStats heroStats, Keyword[] keyword, Ability[] ability,
                            Skills skills) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setKeywords(Lists.asList(null, keyword));
        hero.setAbilities(Lists.asList(null, ability));
        hero.setHeroStats(heroStats);
        hero.setSkills(skills);
        hero = heroRepository.save(hero);
        return hero;
    }

    private Skills createSkills(Integer agility, Integer cunning, Integer spirit, Integer strength, Integer lore, Integer luck, Integer initiative) {
        Skills skills = new Skills();
        skills.setSpirit(spirit);
        skills.setStrength(strength);
        skills.setAgility(agility);
        skills.setCunning(cunning);
        skills.setLuck(luck);
        skills.setLore(lore);
        skills.setAgility(agility);
        skills.setInitiative(initiative);
        return skills;
    }

    private Ability createAbility(String name) {
        Ability ability = abilityRepository.findByName(name);
        if (ability != null) {
            return ability;
        }
        ability = new Ability();
        ability.setName(name);
        ability = abilityRepository.save(ability);
        return abilityRepository.save(ability);
    }

    private Keyword createKeyword(String name) {
        Keyword keyword = keywordRepository.findByName(name);
        if (keyword != null) {
            return keyword;
        }
        keyword = new Keyword();
        keyword.setName(name);
        keyword = keywordRepository.save(keyword);
        return keyword;
    }

    private Item createItem(String name, String description) {
        Item item = itemRepository.findByName(name);
        if (item != null) {
            return item;
        }
        item = new Item();
        item.setName(name);
        item.setDescription(description);
        return itemRepository.save(item);
    }

    private List<Item> generateItem(String name, int size) {
        List<Item> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(createItem(name + i, name + " " + name));
        }
        return list;
    }

    private List<Ability> generateAbilities(String name, int size) {
        List<Ability> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(createAbility(name + i));
        }
        return list;
    }

    private List<Keyword> generateKeywords(String name, int size) {
        List<Keyword> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(createKeyword(name + i));
        }
        return list;
    }
}
