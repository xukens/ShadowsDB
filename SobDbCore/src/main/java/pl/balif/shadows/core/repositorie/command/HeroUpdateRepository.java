package pl.balif.shadows.core.repositorie.command;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.balif.shadows.core.domain.command.HeroLog;
import pl.balif.shadows.core.domain.command.HeroUpdate;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Repository
public interface HeroUpdateRepository extends CrudRepository<HeroUpdate, Long> {

}
