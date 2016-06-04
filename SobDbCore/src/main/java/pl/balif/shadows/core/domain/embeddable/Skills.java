package pl.balif.shadows.core.domain.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import pl.wavesoftware.eid.exceptions.Eid;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

@Embeddable
@Data
@AllArgsConstructor
public class Skills implements Cloneable {

    private Integer agility;
    private Integer cunning;
    private Integer spirit;
    private Integer strength;
    private Integer lore;
    private Integer luck;
    private Integer initiative;

    public Skills(){

    }

    public Skills add(Skills skills) {
        agility += skills.agility;
        cunning += skills.cunning;
        spirit += skills.spirit;
        strength += skills.strength;
        lore += skills.lore;
        luck += skills.luck;
        initiative += skills.initiative;
        return this;
    }

    public Skills subtract(Skills skills) {
        agility -= skills.agility;
        cunning -= skills.cunning;
        spirit -= skills.spirit;
        strength -= skills.strength;
        lore -= skills.lore;
        luck -= skills.luck;
        initiative -= skills.initiative;
        return this;
    }

    public Skills clone() {
        try {
            return (Skills) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new EidRuntimeException(new Eid("20160604:155444"), e);
        }
    }
}
