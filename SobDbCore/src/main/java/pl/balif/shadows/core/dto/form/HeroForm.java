package pl.balif.shadows.core.dto.form;

import lombok.Data;

import java.util.List;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Data
public class HeroForm {

    private long id;
    private String name;
    private Integer initiative;
    private Integer maxHealth;
    private Integer defense;
    private Integer willpower;
    private Integer maxSanity;
    private Integer toHitRange;
    private Integer toHitMelee;
    private Integer combat;
    private Integer maxGrit;
    private SkillsForm skillsForm;
    private List<String> keywords;
    private List<String> abilities;
}
