package pl.balif.shadows.core.domain;


import javax.persistence.Column;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Keyword extends BaseEntity {

    @Column(unique = true)
    private String name;

    public String toString(){
        return name;
    }
}
