package pl.balif.shadows.core.domain;

import java.util.Map;
import java.util.Set;
import lombok.ToString;
import pl.balif.shadows.core.domain.action.command.core.HeroLog;
import pl.balif.shadows.core.domain.embeddable.HeroStats;
import pl.balif.shadows.core.domain.embeddable.Skills;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkState;

/**
 * Player hero object.
 * Created by RudyKot on 2016-05-22.
 */
@Entity
@Data
@ToString(exclude="heroLog")
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

    @OneToOne(mappedBy = "hero", cascade = CascadeType.ALL)
    private HeroLog heroLog;

    @ElementCollection
    @CollectionTable(name ="ITEM_QUANTITY")
    @MapKeyJoinColumn(name="ITEM_ID")
    @Column(name="QUANTITY")
    private Map<Item, Integer> items;

    public void addItem(Item item){
        Integer count = items.get(item);
        count=count==null?0:count;
        checkState(count>=0,"20160607:003838");
        items.put(item,count+1);
    }
}
