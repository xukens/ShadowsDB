package pl.balif.shadows.core.domain.action.command;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdate;
import pl.balif.shadows.core.domain.embeddable.Skills;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Entity
@Data
@DiscriminatorValue("LevelUp")
public class HeroAddLevel extends HeroUpdate {

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
