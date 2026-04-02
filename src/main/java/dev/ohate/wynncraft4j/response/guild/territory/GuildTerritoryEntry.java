package dev.ohate.wynncraft4j.response.guild.territory;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter(AccessLevel.NONE)
public class GuildTerritoryEntry {

    private UUID uuid;
    private String name;
    private String prefix;

}
