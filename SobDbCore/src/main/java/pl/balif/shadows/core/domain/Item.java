package pl.balif.shadows.core.domain;

import pl.balif.shadows.core.domain.embeddable.Skills;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Data
public class Item extends BaseEntity{

	String name;
    String description;
    @Embedded
    Skills skills;
	
}
