package dev.ohate.wynncraft4j.response.leaderboards;

import com.google.gson.annotations.SerializedName;

public enum LeaderboardMetadata {
    @SerializedName("xp") XP("XP"),
    @SerializedName("playtime") PLAYTIME("Playtime"),
    @SerializedName("totalLevel") TOTAL_LEVEL("Total Level"),
    @SerializedName("completions") COMPLETIONS("Completions"),
    @SerializedName("gambits") GAMBITS("Gambits"),
    @SerializedName("level") LEVEL("Level"),
    @SerializedName("territories") TERRITORIES("Territories"),
    @SerializedName("wars") WARS("Wars");

    private final String readableString;

    LeaderboardMetadata(String readableString) {
        this.readableString = readableString;
    }

    public String getReadableString() {
        return this.readableString;
    }

}
