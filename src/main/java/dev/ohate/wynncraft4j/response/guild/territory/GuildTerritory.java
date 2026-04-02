package dev.ohate.wynncraft4j.response.guild.territory;

import dev.ohate.wynncraft4j.response.Location;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;

@Data
@Setter(AccessLevel.NONE)
public class GuildTerritory {

    private String guild;
    private String guildPrefix;
    private String guildColor;
    private Instant acquired;
    private Location location;

}
