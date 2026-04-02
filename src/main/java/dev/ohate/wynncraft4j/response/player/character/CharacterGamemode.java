package dev.ohate.wynncraft4j.response.player.character;

import com.google.gson.annotations.SerializedName;
import dev.ohate.wynncraft4j.util.TextColor;
import lombok.Getter;

@Getter
public enum CharacterGamemode {
    @SerializedName("hardcore")
    HARDCORE(
            "Hardcore",
            "H",
            TextColor.RED
    ),
    @SerializedName("ultimate_ironman")
    ULTIMATE_IRONMAN(
            "Ultimate Ironman",
            "UI",
            TextColor.AQUA
    ),
    @SerializedName("ironman")
    IRONMAN(
            "Ironman",
            "I",
            TextColor.GOLD
    ),
    @SerializedName("craftsman")
    CRAFTSMAN(
            "Craftsman",
            "C",
            TextColor.DARK_AQUA
    ),
    @SerializedName("hunted")
    HUNTED(
            "Hunted",
            "H",
            TextColor.LIGHT_PURPLE
    );

    public static final CharacterGamemode[] GAMEMODE_ORDER = {
            HARDCORE,
            ULTIMATE_IRONMAN,
            IRONMAN,
            CRAFTSMAN,
            HUNTED
    };

    private final String readableString;
    private final String shortenedString;
    private final int color;

    CharacterGamemode(String readableString, String shortenedString, int color) {
        this.readableString = readableString;
        this.shortenedString = shortenedString;
        this.color = color;
    }

}
