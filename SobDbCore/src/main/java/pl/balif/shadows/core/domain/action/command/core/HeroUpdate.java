package pl.balif.shadows.core.domain.action.command.core;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.template.HeroUpdateTemplate;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ACTION")
@AllArgsConstructor
public abstract class HeroUpdate extends BaseEntity{

    @ManyToOne
    private Hero receiver;

    @ManyToOne
    private HeroUpdateMacro entirety;

    @ManyToOne
    private HeroUpdateTemplate template;

    abstract void execute();

    abstract void inverseExecute();

    HeroUpdate(){

    }



}
