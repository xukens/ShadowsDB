package pl.balif.shadows.core.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.Hero;

import java.util.List;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findByName(String name);
}
