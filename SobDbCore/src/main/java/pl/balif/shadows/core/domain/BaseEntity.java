package pl.balif.shadows.core.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by RudyKot on 2016-05-22.
 */
@MappedSuperclass
@Data
//@Access(AccessType.PROPERTY)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Long version;
}
