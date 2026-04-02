package dev.ohate.wynncraft4j.response.player;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Data
@Setter(AccessLevel.NONE)
public class PlayerCombatStat {

    @Nullable
    private Integer kills;
    @Nullable
    private Integer deaths;

}
