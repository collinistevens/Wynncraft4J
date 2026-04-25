package dev.ohate.wynncraft4j.response.player;

import com.google.gson.annotations.SerializedName;

public enum DungeonType {
    @SerializedName("Decrepit Sewers") DECREPIT_SEWERS("Decrepit Sewers", true),
    @SerializedName("Infested Pit") INFESTED_PIT("Infested Pit", true),
    @SerializedName("Underworld Crypt") UNDERWORLD_CRYPT("Underworld Crypt", true),
    @SerializedName("Timelost Sanctum") TIMELOST_SANCTUM("Timelost Sanctum", true),
    @SerializedName("Sand-Swept Tomb") SAND_SWEPT_TOMB("Sand-Swept Tomb", true),
    @SerializedName("Ice Barrows") ICE_BARROWS("Ice Barrows", true),
    @SerializedName("Undergrowth Ruins") UNDERGROWTH_RUINS("Undergrowth Ruins", true),
    @SerializedName("Galleon's Graveyard") GALLEONS_GRAVEYARD("Galleon's Graveyard", true),
    @SerializedName("Fallen Factory") FALLEN_FACTORY("Fallen Factory"),
    @SerializedName("Eldritch Outlook") ELDRITCH_OUTLOOK("Eldritch Outlook");

    private final String name;
    private final boolean corrupted;

    DungeonType(String name, boolean corrupted) {
        this.name = name;
        this.corrupted = corrupted;
    }

    DungeonType(String name) {
        this(name, false);
    }

    public String getName() {
        return this.name;
    }

    public boolean hasCorrupted() {
        return this.corrupted;
    }

}
