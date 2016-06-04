package pl.balif.shadows.core.domain.action.command.core;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.template.HeroUpdateTemplate;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;
import static pl.wavesoftware.eid.utils.EidPreconditions.checkState;

/**
 * Created by RudyKot on 2016-06-01.
 */
@Entity
@Data
public class HeroLog extends BaseEntity {

    @OneToOne
    private Hero hero;

    @OneToMany(cascade = CascadeType.PERSIST)
    @OrderColumn(name = "EXECUTION_ORDER")
    private List<HeroUpdate> commands;

    protected HeroLog() {
        super();
    }

    public HeroLog(Hero hero) {
        this();
        this.hero = hero;
        commands = new LinkedList<>();
    }

    public void executeCommand(HeroUpdateTemplate heroUpdateTemplate) {
        checkNotNull(heroUpdateTemplate, "20160604:174928");
        HeroUpdate heroUpdate = heroUpdateTemplate.createCommand(hero);
        commands.add(heroUpdate);
        heroUpdate.execute();
    }

}
