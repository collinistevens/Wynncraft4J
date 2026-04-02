package dev.ohate.wynncraft4j.response.guild;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class GuildSeasonRank {

    private int rating;
    private int finalTerritories;

}
