package dev.ohate.wynncraft4j.response.leaderboards.type;

import dev.ohate.wynncraft4j.response.guild.banner.Banner;
import dev.ohate.wynncraft4j.response.leaderboards.Leaderboard;

public class GuildLeaderboard extends Leaderboard {

    private String prefix;
    private Banner banner;

    public String getPrefix() {
        return this.prefix;
    }

    public Banner getBanner() {
        return this.banner;
    }

}
