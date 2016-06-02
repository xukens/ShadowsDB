package pl.balif.shadows.core.domain.action.command.core;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.template.HeroUpdateTemplate;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkState;

/**
 * Created by RudyKot on 2016-06-01.
 */
@Entity
@Data
public class HeroLog extends BaseEntity {

    @OneToOne
    private Hero hero;

    @OneToOne(cascade = CascadeType.ALL)
    private HeroUpdateMacro macro;

    protected HeroLog() {
        super();
    }

    public HeroLog(Hero hero) {
        this();
        this.hero = hero;
        macro = new HeroUpdateMacro(hero);

    }

    public void execute(HeroUpdateTemplate heroUpdateTemplate) {
//        checkState(heroUpdate.getId() == null, "20160602:000141");
        HeroUpdate heroUpdate = new H
        macro.getCommands().add(heroUpdate);
        heroUpdate.setEntirety(macro);
        // heroUpdate.execute();
    }

}
