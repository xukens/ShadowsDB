package pl.balif.shadows.core.domain.action.template;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdate;
import pl.balif.shadows.core.domain.action.command.core.HeroUpdateMacro;

/**
 * @author Paweł Nowakowski <pawel.nowakowski@coi.gov.pl>
 */
@Entity
@Data
public class HeroUpdateMacroTemplate extends HeroUpdateTemplate<HeroUpdateMacro> {

    @ManyToMany
    Set<HeroUpdateTemplate> commandsTemplate;

    @Override
    public HeroUpdateMacro createCommand(Hero hero) {
        List<HeroUpdate> commands = commandsTemplate.stream()
                .map(heroUpdateTemplate -> heroUpdateTemplate.createCommand(hero)).collect(Collectors.toList());
        HeroUpdateMacro command = new HeroUpdateMacro(hero, commands);
        return command;
    }
}
