package pl.balif.shadows.core.domain.command;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import lombok.Data;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Data
@DiscriminatorValue("HeroMacro")
public class HeroUpdateMacro extends HeroUpdate {

    @OneToMany(mappedBy = "owner")
    @OrderColumn(name = "EXECUTION_ORDER")
    private LinkedList<HeroUpdate> commands;

    private String description;

    @Override
    void execute() {
        commands.forEach(HeroUpdate::execute);
    }

    @Override
    void inverseExecute() {
        commands.descendingIterator().forEachRemaining(HeroUpdate::inverseExecute);
    }
}
