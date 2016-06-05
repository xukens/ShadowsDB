package pl.balif.shadows.core.domain.action.template;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.command.HeroAddSkills;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdate;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdateMacro;
import pl.balif.shadows.core.domain.embeddable.Skills;

/**
 * @author Paweł Nowakowski <pawel.nowakowski@coi.gov.pl>
 */
@Entity
@Data
public class HeroAddSkillsTemplate extends HeroUpdateTemplate<HeroAddSkills> {

    @Embedded
    private Skills skills;

    @Override
    public HeroAddSkills createCommand(Hero receiver) {
        HeroAddSkills command = new HeroAddSkills(receiver, skills.clone());
        return command;
    }

    public HeroAddSkillsTemplate(String name, Skills skills) {
        super(name);
        this.skills = skills;
    }
}
