package pl.balif.shadows.core.service;


import java.util.List;
import pl.balif.shadows.core.dto.form.HeroForm;

/**
 * Created by RudyKot on 2016-05-26.
 */
public interface SobHeroService {

    List<HeroForm> getHeroes();

    HeroForm getHero(Long id);

    Long createNewHero(Long heroClassId, String heroName);
}
