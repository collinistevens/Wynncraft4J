package dev.ohate.wynncraft4j.response.leaderboards;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public enum LeaderboardMetadata {
    @SerializedName("xp")
    XP("XP"),
    @SerializedName("playtime")
    PLAYTIME("Playtime"),
    @SerializedName("totalLevel")
    TOTAL_LEVEL("Total Level"),
    @SerializedName("characterUuid")
    CHARACTER_UUID("Character UUID"),
    @SerializedName("characterType")
    CHARACTER_TYPE("Character Type"),
    @SerializedName("completions")
    COMPLETIONS("Completions"),
    @SerializedName("gambits")
    GAMBITS("Gambits"),
    @SerializedName("level")
    LEVEL("Level"),
    @SerializedName("territories")
    TERRITORIES("Territories"),
    @SerializedName("wars")
    WARS("Wars");

    private final String readableString;

    LeaderboardMetadata(String readableString) {
        this.readableString = readableString;
    }

}
