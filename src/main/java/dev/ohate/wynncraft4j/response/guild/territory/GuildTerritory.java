package dev.ohate.wynncraft4j.response.guild.territory;

import dev.ohate.wynncraft4j.response.Location;

import java.time.Instant;

public class GuildTerritory {

    private String guild;
    private String guildPrefix;
    private String guildColor;
    private Instant acquired;
    private Location location;

    public String getGuild() {
        return this.guild;
    }

    public String getGuildPrefix() {
        return this.guildPrefix;
    }

    public String getGuildColor() {
        return this.guildColor;
    }

    public Instant getAcquired() {
        return this.acquired;
    }

    public Location getLocation() {
        return this.location;
    }

}
