package pl.balif.shadows.core.domain.command;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import lombok.Data;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.embeddable.Skills;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Data
@DiscriminatorValue("SkillsAdd")
public class HeroAddSkills extends HeroUpdate {

    @Embedded
    Skills skills;

    @Override
    void execute() {
        Hero h = getReceiver();
        h.getSkills().add(skills);
    }

    @Override
    void inverseExecute() {
        Hero h = getReceiver();
        h.getSkills().subtract(skills);
    }
}
