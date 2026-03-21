package dev.ohate.wynncraft4j.response.player.character;

import com.google.gson.annotations.SerializedName;

public enum CharacterStat {
    @SerializedName("lootruns") LOOTRUNS,
    @SerializedName("professions") PROFESSIONS,
    @SerializedName("deaths") DEATHS,
    @SerializedName("chestsFound") CHESTS_FOUND,
    @SerializedName("contentCompletion") CONTENT_COMPLETION,
    @SerializedName("dungeons") DUNGEONS,
    @SerializedName("discoveries") DISCOVERIES,
    @SerializedName("itemsIdentified") ITEMS_IDENTIFIED,
    @SerializedName("wars") WARS,
    @SerializedName("playtime") PLAYTIME,
    @SerializedName("caves") CAVES,
    @SerializedName("quests") QUESTS,
    @SerializedName("raids") RAIDS,
    @SerializedName("pvp") PVP,
    @SerializedName("blocksWalked") BLOCKS_WALKED,
    @SerializedName("worldEvents") WORLD_EVENTS,
    @SerializedName("skillPoints") SKILL_POINTS,
    @SerializedName("logins") LOGINS,
    @SerializedName("mobsKilled") MOBS_KILLED
}
