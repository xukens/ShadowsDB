package pl.balif.shadows.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Ability extends BaseEntity {
    @Column(unique = true)
    private String name;
    public String toString() {
        return name;
    }
}
