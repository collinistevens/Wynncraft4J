package dev.ohate.wynncraft4j.response.guild;

import dev.ohate.wynncraft4j.response.ContentStat;
import dev.ohate.wynncraft4j.response.player.RaidType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;

@Data
@Setter(AccessLevel.NONE)
public class GuildMember {

    private String username;
    private boolean online;
    private String server;
    private long contributed;
    private int contributionRank;
    private Instant joined;
    private ContentStat<RaidType> guildRaids;

}
