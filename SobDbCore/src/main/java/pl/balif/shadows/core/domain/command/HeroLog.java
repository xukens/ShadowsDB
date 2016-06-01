package pl.balif.shadows.core.domain.command;

import java.util.LinkedList;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import lombok.Data;
import pl.balif.shadows.core.domain.BaseEntity;
import pl.balif.shadows.core.domain.Hero;

/**
 * Created by RudyKot on 2016-06-01.
 */
@Data
public class HeroLog extends BaseEntity {

    @OneToOne
    private Hero hero;

    @OneToOne
    private HeroUpdateMacro macro;

}
