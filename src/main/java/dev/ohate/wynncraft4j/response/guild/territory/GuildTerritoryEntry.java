package dev.ohate.wynncraft4j.response.guild.territory;

import java.util.UUID;

public class GuildTerritoryEntry {

    private UUID uuid;
    private String name;
    private String prefix;

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

}
