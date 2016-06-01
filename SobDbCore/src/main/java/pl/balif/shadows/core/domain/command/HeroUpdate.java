package pl.balif.shadows.core.domain.command;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACTION")
public abstract class HeroUpdate extends BaseEntity{

    @ManyToOne
    private HeroUpdateMacro owner;

    abstract void execute();

    abstract void inverseExecute();
}
