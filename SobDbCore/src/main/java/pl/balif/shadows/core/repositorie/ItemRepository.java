package pl.balif.shadows.core.repositorie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.balif.shadows.core.domain.Ability;
import pl.balif.shadows.core.domain.Item;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item findByName(String name);
}
