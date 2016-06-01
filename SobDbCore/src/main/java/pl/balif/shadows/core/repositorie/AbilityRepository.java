package pl.balif.shadows.core.repositorie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.balif.shadows.core.domain.Ability;

import java.util.List;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Repository
public interface AbilityRepository extends CrudRepository<Ability, Long> {

    Ability findByName(String name);
}
