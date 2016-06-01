package pl.balif.shadows.core.domain;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import lombok.Data;
import pl.balif.shadows.core.domain.embeddable.Skills;
import pl.balif.shadows.core.domain.embeddable.HeroStats;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Defining stats of hero class that player can choose on game start.
 * New Hero will copy stats from this class.
 * Created by RudyKot on 2016-05-22.
 */
@Entity
@Data
public class HeroClass extends BaseEntity{

    @Column(unique = true)
    private String name;

    @Embedded
    private HeroStats heroStats;
    @Embedded
    private Skills skills;

    @ManyToMany
    private List<Keyword> keywords;
    @ManyToMany
    private List<Ability> abilities;

    @ManyToMany
    private List<Item> items;
}
