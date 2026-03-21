package dev.ohate.wynncraft4j.response.player;

import org.jetbrains.annotations.Nullable;

public class PlayerCombatStat {

    @Nullable private Integer kills;
    @Nullable private Integer deaths;

    @Nullable
    public Integer getKills() {
        return this.kills;
    }

    @Nullable
    public Integer getDeaths() {
        return this.deaths;
    }

}
