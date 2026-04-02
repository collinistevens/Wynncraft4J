package dev.ohate.wynncraft4j.response.multiselector;

import dev.ohate.wynncraft4j.response.player.PlayerRankProvider;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PlayerOption implements PlayerRankProvider {

    private String username;
    private String rank;
    private String supportRank;

}
