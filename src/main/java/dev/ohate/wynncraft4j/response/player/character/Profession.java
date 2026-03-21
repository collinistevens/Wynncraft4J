package dev.ohate.wynncraft4j.response.player.character;

import com.google.gson.annotations.SerializedName;

public enum Profession {
    @SerializedName("fishing") FISHING("fishingLevel", "Fishing"),
    @SerializedName("woodcutting") WOODCUTTING("woodcuttingLevel", "Woodcutting"),
    @SerializedName("mining") MINING("miningLevel", "Mining"),
    @SerializedName("farming") FARMING("farmingLevel", "Farming"),
    @SerializedName("scribing") SCRIBING("scribingLevel", "Scribing"),
    @SerializedName("jeweling") JEWELING("jewelingLevel", "Jeweling"),
    @SerializedName("alchemism") ALCHEMISM("alchemismLevel", "Alchemism"),
    @SerializedName("cooking") COOKING("cookingLevel", "Cooking"),
    @SerializedName("weaponsmithing") WEAPONSMITHING("weaponsmithingLevel", "Weaponsmithing"),
    @SerializedName("tailoring") TAILORING("tailoringLevel", "Tailoring"),
    @SerializedName("woodworking") WOODWORKING("woodworkingLevel", "Woodworking"),
    @SerializedName("armouring") ARMOURING("armouringLevel", "Armouring");

    private final String key;
    private final String readableString;

    Profession(String key, String readableString) {
        this.key = key;
        this.readableString = readableString;
    }

    public String getReadableString() {
        return this.readableString;
    }

    public String getKey() {
        return this.key;
    }

}
