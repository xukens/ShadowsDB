package pl.balif.shadows.core.repositorie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.balif.shadows.core.domain.Keyword;

import java.util.List;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Long> {

    Keyword findByName(String name);
}
