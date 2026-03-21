package dev.ohate.wynncraft4j.response.guild.banner;

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

    public int getColor() {
        return this.color;
    }

}
