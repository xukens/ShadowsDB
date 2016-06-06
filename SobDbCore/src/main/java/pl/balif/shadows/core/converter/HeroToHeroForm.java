package pl.balif.shadows.core.converter;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.Ability;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.Keyword;
import pl.balif.shadows.core.domain.embeddable.HeroStats;
import pl.balif.shadows.core.dto.form.HeroForm;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public class HeroToHeroForm implements Converter<Hero, HeroForm> {

    private final SkillsToSkillsForm skillsToSkillsForm;
    private final ItemToItemForm itemToItemForm;

    @Autowired
    public HeroToHeroForm(SkillsToSkillsForm skillsToSkillsForm, ItemToItemForm itemToItemForm) {
        this.skillsToSkillsForm = skillsToSkillsForm;
        this.itemToItemForm = itemToItemForm;
    }

    @Override
    public HeroForm convert(Hero h) {
        HeroForm hf = new HeroForm();
        hf.setId(h.getId());
        hf.setName(h.getName());
        HeroStats hs = h.getHeroStats();
        hf.setMaxHealth(hs.getMaxHealth());
        hf.setMaxSanity(hs.getMaxSanity());
        hf.setToHitRange(hs.getToHitRange());
        hf.setToHitMelee(hs.getToHitMelee());
        hf.setCombat(hs.getCombat());
        hf.setMaxGrit(hs.getMaxGrit());
        hf.setDefense(hs.getDefense());
        hf.setWillpower(hs.getWillpower());
        hf.setSkillsForm(skillsToSkillsForm.convert(h.getSkills()));
        hf.setKeywords(h.getKeywords().stream()
                .map(Keyword::toString).collect(Collectors.toList())
        );
        hf.setAbilities(h.getAbilities().stream()
                .map(Ability::toString).collect(Collectors.toList())
        );
        hf.setItemFormList(h.getItems().keySet().stream()
                .map(itemToItemForm::convert).collect(Collectors.toList()));
        return hf;
    }

}
