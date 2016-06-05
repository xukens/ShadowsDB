package pl.balif.shadows.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.balif.shadows.core.converter.ConversionService;
import pl.balif.shadows.core.domain.action.template.HeroAddSkillsTemplate;
import pl.balif.shadows.core.domain.embeddable.Skills;
import pl.balif.shadows.core.dto.form.SkillsForm;
import pl.balif.shadows.core.repositorie.action.HeroTemplateRepository;
import pl.balif.shadows.core.service.TemplateService;

/**
 * Created by RudyKot on 2016-06-05.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    private final ConversionService conversionService;
    private final HeroTemplateRepository heroTemplateRepository;

    @Autowired
    public TemplateServiceImpl(ConversionService conversionService, HeroTemplateRepository heroTemplateRepository) {
        this.conversionService = conversionService;
        this.heroTemplateRepository = heroTemplateRepository;
    }

    @Override
    public Long createAddSkillsTemplate(String name, SkillsForm skillsForm) {
        HeroAddSkillsTemplate template = new HeroAddSkillsTemplate(name,
                conversionService.convert(skillsForm, Skills.class));
        Long id = heroTemplateRepository.save(template).getId();
        return id;
    }
}
