package pl.balif.shadows.core.domain.action.template;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 * @author Paweł Nowakowski <pawel.nowakowski@coi.gov.pl>
 */
@Entity
@Data
public class HeroUpdateMacroTemplate extends HeroUpdateTemplate {

    @ManyToMany
    Set<HeroUpdateTemplate> commands;
}
