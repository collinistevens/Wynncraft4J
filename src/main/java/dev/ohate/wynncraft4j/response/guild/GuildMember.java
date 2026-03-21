package dev.ohate.wynncraft4j.response.guild;

import dev.ohate.wynncraft4j.response.ContentStat;

import java.time.Instant;

public class GuildMember {

    private String username;
    private boolean online;
    private String server;
    private long contributed;
    private int contributionRank;
    private Instant joined;
    private ContentStat guildRaids;

    public String getUsername() {
        return this.username;
    }

    public boolean isOnline() {
        return this.online;
    }

    public String getServer() {
        return this.server;
    }

    public long getContributed() {
        return this.contributed;
    }

    public int getContributionRank() {
        return this.contributionRank;
    }

    public Instant getJoined() {
        return this.joined;
    }

    public ContentStat getGuildRaids() {
        return this.guildRaids;
    }

}
