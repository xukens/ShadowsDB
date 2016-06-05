package pl.balif.shadows.core.repositorie.action;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.balif.shadows.core.domain.action.command.core.HeroLog;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Repository
public interface HeroLogRepository extends CrudRepository<HeroLog, Long> {

}
