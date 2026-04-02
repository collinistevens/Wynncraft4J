package dev.ohate.wynncraft4j.response.guild;

import dev.ohate.wynncraft4j.response.guild.territory.GuildTerritory;

import java.util.Map;

public class TerritoryResponse {

    private Map<String, GuildTerritory> territories;

    public Map<String, GuildTerritory> getTerritories() {
        return this.territories;
    }

}
