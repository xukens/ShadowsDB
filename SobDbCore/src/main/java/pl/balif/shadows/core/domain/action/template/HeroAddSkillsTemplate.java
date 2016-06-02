package pl.balif.shadows.core.domain.action.template;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import pl.balif.shadows.core.domain.embeddable.Skills;

/**
 * @author Paweł Nowakowski <pawel.nowakowski@coi.gov.pl>
 */
@Entity
@Data
public class HeroAddSkillsTemplate extends HeroUpdateTemplate {

    @Embedded
    private Skills skills;
}
