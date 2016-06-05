package pl.balif.shadows.core.domain.action.template;

import javax.persistence.Entity;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdate;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdateMacro;

/**
 * @author Paweł Nowakowski <balif.n@gmail.com>
 */
@Entity
@Data
public abstract class HeroUpdateTemplate<T extends HeroUpdate> extends BaseEntity {
    String name;

    public abstract T createCommand(Hero receiver);

    protected HeroUpdateTemplate() {

    }

    public HeroUpdateTemplate(String name) {
        this.name = name;
    }
}
