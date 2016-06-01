package pl.balif.shadows.core.domain.embeddable;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class HeroStats {

    private Integer maxHealth;
    private Integer maxSanity;
    private Integer defense;
    private Integer willpower;
    private Integer toHitRange;
    private Integer toHitMelee;
    private Integer combat;
    private Integer maxGrit;
}
