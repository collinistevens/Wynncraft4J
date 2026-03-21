package dev.ohate.wynncraft4j.response.guild;

import com.google.gson.annotations.SerializedName;
import dev.ohate.wynncraft4j.response.guild.banner.Banner;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class Guild {

    private UUID uuid;
    private String name;
    private String prefix;
    private int level;
    private int xpPercent;
    private int territories;
    private int wars;
    private Instant created;
    @SerializedName("members") private GuildRoster roster;
    private int online;
    @Nullable private Banner banner;
    private Map<String, GuildSeasonRank> seasonRanks;

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public int getLevel() {
        return this.level;
    }

    public int getXpPercent() {
        return this.xpPercent;
    }

    public int getTerritories() {
        return this.territories;
    }

    public int getWars() {
        return this.wars;
    }

    public Instant getCreated() {
        return this.created;
    }

    public GuildRoster getRoster() {
        return this.roster;
    }

    public int getOnline() {
        return this.online;
    }

    @Nullable
    public Banner getBanner() {
        return this.banner;
    }

    public Map<String, GuildSeasonRank> getSeasonRanks() {
        return this.seasonRanks;
    }

}
