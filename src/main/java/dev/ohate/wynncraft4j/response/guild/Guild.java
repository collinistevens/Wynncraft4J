package dev.ohate.wynncraft4j.response.guild;

import com.google.gson.annotations.SerializedName;
import dev.ohate.wynncraft4j.response.guild.banner.Banner;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Data
@Setter(AccessLevel.NONE)
public class Guild {

    private UUID uuid;
    private String name;
    private String prefix;
    private int level;
    private int xpPercent;
    private int territories;
    private int wars;
    private Instant created;
    @SerializedName("members")
    private GuildRoster roster;
    private int online;
    @Nullable
    private Banner banner;
    private Map<String, GuildSeasonRank> seasonRanks;

}
