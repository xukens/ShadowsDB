package pl.balif.shadows.core.domain;

import java.util.Map;
import java.util.Set;
import pl.balif.shadows.core.domain.embeddable.HeroStats;
import pl.balif.shadows.core.domain.embeddable.Skills;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Player hero object.
 * Created by RudyKot on 2016-05-22.
 */
@Entity
@Data
public class Hero extends BaseEntity {

    private String name;
    @Embedded
    private HeroStats heroStats;
    @Embedded
    private Skills skills;
    @ManyToOne(fetch = FetchType.LAZY)
    private HeroClass heroClass;

    @ManyToMany
    private List<Keyword> keywords;
    @ManyToMany
    private List<Ability> abilities;

    @ElementCollection
    @CollectionTable(name ="ITEM_QUANTITY")
    @MapKeyJoinColumn(name="ITEM_ID")
    @Column(name="QUANTITY")
    private Map<Item, Integer> items;
}
