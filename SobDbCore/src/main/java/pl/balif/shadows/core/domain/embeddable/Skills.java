package pl.balif.shadows.core.domain.embeddable;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Skills {

	private Integer agility;
	private Integer cunning;
	private Integer spirit;
	private Integer strength;
	private Integer lore;
	private Integer luck;
	private Integer initiative;

	public Skills add(Skills skills){
		agility+=skills.agility;
		cunning+=skills.cunning;
		spirit+=skills.spirit;
		strength+=skills.strength;
		lore+=skills.lore;
		luck+=skills.luck;
		initiative+=skills.initiative;
		return this;
	}

	public Skills subtract(Skills skills){
		agility-=skills.agility;
		cunning-=skills.cunning;
		spirit-=skills.spirit;
		strength-=skills.strength;
		lore-=skills.lore;
		luck-=skills.luck;
		initiative-=skills.initiative;
		return this;
	}

}
