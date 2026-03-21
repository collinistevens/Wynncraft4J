package dev.ohate.wynncraft4j.response.player;

import java.util.UUID;

public class PlayerGuild {

    private UUID uuid;
    private String name;
    private String prefix;
    private String rank;
    private String rankStars;

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getRank() {
        return this.rank;
    }

    public String getRankStars() {
        return this.rankStars;
    }

}
