package pl.balif.shadows.core.service;


import java.util.List;
import pl.balif.shadows.core.domain.action.template.HeroUpdateTemplate;
import pl.balif.shadows.core.dto.form.HeroForm;
import pl.balif.shadows.core.dto.form.SkillsForm;

/**
 * Created by RudyKot on 2016-05-26.
 */
public interface TemplateService {

    Long createAddSkillsTemplate(String name, SkillsForm skillsForm);
}
