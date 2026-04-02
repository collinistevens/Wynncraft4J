package dev.ohate.wynncraft4j.response.leaderboards.type;

import dev.ohate.wynncraft4j.response.guild.banner.Banner;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardEntry;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(callSuper = true)
public class GuildLeaderboardEntry extends LeaderboardEntry {

    private String prefix;
    private Banner banner;

}
