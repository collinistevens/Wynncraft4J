package dev.ohate.wynncraft4j.response.guild.banner;

import dev.ohate.wynncraft4j.util.TextColor;
import lombok.Getter;

@Getter
public enum BannerColor {
    WHITE(0xBABFBE),
    ORANGE(0xBB6016),
    MAGENTA(0x933A8C),
    LIGHT_BLUE(0x2C87A4),
    YELLOW(0xBDA02D),
    LIME(0x5E9217),
    PINK(0xB86981),
    GRAY(0x343A3C),
    SILVER(0x747470),
    CYAN(0x117676),
    PURPLE(0x662589),
    BLUE(0x2D3380),
    BROWN(0x603D25),
    GREEN(0x455B10),
    RED(0x85231D),
    BLACK(0x151518);

    private final int color;

    BannerColor(int color) {
        this.color = color;
    }

    public static int parse(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Banner color string must not be null or empty");
        }

        value = value.toLowerCase();

        return switch (value) {
            case "white" -> WHITE.color;
            case "orange" -> ORANGE.color;
            case "magenta" -> MAGENTA.color;
            case "light-blue" -> LIGHT_BLUE.color;
            case "yellow" -> YELLOW.color;
            case "lime" -> LIME.color;
            case "pink" -> PINK.color;
            case "gray" -> GRAY.color;
            case "silver" -> SILVER.color;
            case "cyan" -> CYAN.color;
            case "purple" -> PURPLE.color;
            case "blue" -> BLUE.color;
            case "brown" -> BROWN.color;
            case "green" -> GREEN.color;
            case "red" -> RED.color;
            case "black" -> BLACK.color;
            default -> throw new IllegalArgumentException("Unknown banner color: \"" + value + "\"");
        };
    }

}
