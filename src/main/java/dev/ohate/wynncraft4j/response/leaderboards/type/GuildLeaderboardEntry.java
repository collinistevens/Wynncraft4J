package dev.ohate.wynncraft4j.response.leaderboards.type;

import dev.ohate.wynncraft4j.response.guild.banner.Banner;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardEntry;

public class GuildLeaderboardEntry extends LeaderboardEntry {

    private String prefix;
    private Banner banner;

    public String getPrefix() {
        return this.prefix;
    }

    public Banner getBanner() {
        return this.banner;
    }

}
