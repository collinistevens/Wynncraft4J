package dev.ohate.wynncraft4j.response.player.character;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ProfessionStat {

    private int level;
    private int xpPercent;

}
