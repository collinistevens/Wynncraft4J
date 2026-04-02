package dev.ohate.wynncraft4j.response.player.character;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class SkillPoints {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int defence;
    private int agility;

}
