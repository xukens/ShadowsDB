package pl.balif.shadows.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.embeddable.Skills;
import pl.balif.shadows.core.dto.form.SkillsForm;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public class SkillsToSkillsForm implements Converter<Skills, SkillsForm> {

    @Override
    public SkillsForm convert(Skills skills) {
        SkillsForm skillsForm = new SkillsForm();
        skillsForm.setAgility(skills.getAgility());
        skillsForm.setCunning(skills.getCunning());
        skillsForm.setLore(skills.getLore());
        skillsForm.setLuck(skills.getLuck());
        skillsForm.setSpirit(skills.getSpirit());
        skillsForm.setStrength(skills.getSpirit());
        return skillsForm;
    }
}
