package pl.balif.shadows.core.domain.command;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import lombok.Data;
import pl.balif.shadows.core.domain.Hero;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkState;

/**
 * Created by RudyKot on 2016-05-30.
 */
@Entity
@Data
@DiscriminatorValue("HeroMacro")
public class HeroUpdateMacro extends HeroUpdate {
//
    @OneToMany(mappedBy="entirety", cascade = CascadeType.PERSIST)
    @OrderColumn(name = "EXECUTION_ORDER")
    private List<HeroUpdate> commands;

    private String description;

    protected HeroUpdateMacro(){
        super();
        commands=new LinkedList<>();
    }

    public HeroUpdateMacro(Hero reciver, List<HeroUpdate> commands){
        this();
        this.setReceiver(reciver);
        this.commands.addAll(commands);
    }

    public HeroUpdateMacro(Hero reciver){
        this();
        this.setReceiver(reciver);
    }

    @Override
    void execute() {
        commands.forEach(HeroUpdate::execute);
    }

    @Override
    void inverseExecute() {
//        commands.descendingIterator().forEachRemaining(HeroUpdate::inverseExecute);
    }

   public  List<HeroUpdate> getCommands() {
        return commands;
    }

    void setCommands(List<HeroUpdate> commands) {
        this.commands = commands;
    }
}
