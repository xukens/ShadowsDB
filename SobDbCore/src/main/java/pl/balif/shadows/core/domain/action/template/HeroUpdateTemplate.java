package pl.balif.shadows.core.domain.action.template;

import javax.persistence.Entity;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdate;

/**
 * @author Paweł Nowakowski <pawel.nowakowski@coi.gov.pl>
 */
@Entity
@Data
public abstract class HeroUpdateTemplate extends BaseEntity {
    String name;

    public abstract HeroUpdate createCommand();
}
