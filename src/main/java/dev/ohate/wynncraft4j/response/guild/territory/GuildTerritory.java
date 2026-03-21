package dev.ohate.wynncraft4j.response.guild.territory;

import java.time.Instant;

public class GuildTerritory {

    private GuildTerritoryEntry guild;
    private Instant acquired;
    private GuildTerritoryLocation location;

    public GuildTerritoryEntry getGuild() {
        return this.guild;
    }

    public Instant getAcquired() {
        return this.acquired;
    }

    public GuildTerritoryLocation getLocation() {
        return this.location;
    }

}
