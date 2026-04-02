package dev.ohate.wynncraft4j.response.guild;

import dev.ohate.wynncraft4j.response.guild.territory.GuildTerritory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Map;

@Data
@Setter(AccessLevel.NONE)
public class TerritoryResponse {

    private Map<String, GuildTerritory> territories;

}
