package dev.ohate.wynncraft4j.response.player;

import com.google.gson.annotations.SerializedName;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import lombok.Getter;

import static dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType.*;

@Getter
public enum RaidType {
    @SerializedName("Nest of the Grootslangs") NEST_OF_THE_GROOTSLANGS(
            "Nest of the Grootslangs",
            "NOTG",
            GROOTSLANG_COMPLETION,
            GROOTSLANG_SR_PLAYERS,
            GROOTSLANG_SR_GUILDS
    ),
    @SerializedName("Orphion's Nexus of Light") NEXUS_OF_LIGHT(
            "Orphion's Nexus of Light",
            "NOL",
            ORPHION_COMPLETION,
            ORPHION_SR_PLAYERS,
            ORPHION_SR_GUILDS
    ),
    @SerializedName("The Canyon Colossus") THE_CANYON_COLOSSUS(
            "The Canyon Colossus",
            "TCC",
            COLOSSUS_COMPLETION,
            COLOSSUS_SR_PLAYERS,
            COLOSSUS_SR_GUILDS
    ),
    @SerializedName("The Nameless Anomaly") THE_NAMELESS_ANOMALY(
            "The Nameless Anomaly",
            "TNA",
            NAMELESS_COMPLETION,
            NAMELESS_SR_PLAYERS,
            NAMELESS_SR_GUILDS
    ),
    @SerializedName(value = "The Wartorn Palace", alternate = "unknown") THE_WARTORN_PALACE(
            "The Wartorn Palace",
            "WTP",
            null,
            null,
            null
    );

    private final String readableString;
    private final String shortenedString;
    private final LeaderboardType completionLeaderboard;
    private final LeaderboardType srPlayersLeaderboard;
    private final LeaderboardType srGuildsLeaderboard;

    RaidType(
            String readableString,
            String shortenedString,
            LeaderboardType completionLeaderboard,
            LeaderboardType srPlayersLeaderboard,
            LeaderboardType srGuildsLeaderboard
    ) {
        this.readableString = readableString;
        this.shortenedString = shortenedString;
        this.completionLeaderboard = completionLeaderboard;
        this.srPlayersLeaderboard = srPlayersLeaderboard;
        this.srGuildsLeaderboard = srGuildsLeaderboard;
    }

    public static RaidType fromLeaderboardType(LeaderboardType type) {
        for (RaidType raidType : values()) {
            if (raidType.getCompletionLeaderboard() == type ||
                    raidType.getSrPlayersLeaderboard() == type ||
                    raidType.getSrGuildsLeaderboard() == type) {
                return raidType;
            }
        }
        return null;
    }

}
