package dev.ohate.wynncraft4j.response.multiselector;

import dev.ohate.wynncraft4j.response.player.PlayerRankProvider;

public class PlayerOption implements PlayerRankProvider {

    private String username;
    private String rank;
    private String supportRank;

    @Override
    public String getRank() {
        return this.rank;
    }

    @Override
    public String getSupportRank() {
        return this.supportRank;
    }

}
