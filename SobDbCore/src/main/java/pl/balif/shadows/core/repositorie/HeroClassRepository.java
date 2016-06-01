package pl.balif.shadows.core.repositorie;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.Hero;
import pl.balif.shadows.core.domain.HeroClass;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public interface HeroClassRepository extends JpaRepository<HeroClass, Long> {

    HeroClass findByName(String name);
}
