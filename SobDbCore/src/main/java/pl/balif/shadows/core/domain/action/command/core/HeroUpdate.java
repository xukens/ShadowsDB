package pl.balif.shadows.core.domain.action.command.core;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.template.HeroUpdateTemplate;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACTION")
public abstract class HeroUpdate extends BaseEntity{

    @ManyToOne
    private Hero receiver;

    public HeroUpdate(Hero receiver) {
        checkNotNull(receiver,"20160604:163629");
        this.receiver = receiver;
    }

    protected abstract void execute();

    protected abstract void inverseExecute();

    protected HeroUpdate(){
    }

}
