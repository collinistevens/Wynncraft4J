package dev.ohate.wynncraft4j.response.player;

public enum PlayerRank {
    UNKNOWN("Unknown", 0xFFFFFF, 0xFFFFFF),
    PLAYER("Player", 0xAAAAAA, 0xAAAAAA),
    VIP("VIP", 0x00AA00, 0x55FF55),
    VIPPLUS("VIP+", 0x55FFFF, 0x00AAAA),
    HERO("Hero", 0xAA00AA, 0xFF55FF),
    HEROPLUS("Hero+", 0xBC3C7C, 0xC571A5),
    CHAMPION("Champion", 0xFFFF55, 0xFFAA00),
    MEDIA("Media", 0xFF55FF, 0xAA00AA),
    ART("Artist", 0x00AAAA, 0x55FFFF),
    QA("QA", 0x00AAAA, 0x55FFFF),
    ITEM("Item", 0x00AAAA, 0x55FFFF),
    HYBRID("Hybrid", 0x00AAAA, 0x55FFFF),
    CMD("CMD", 0x00AAAA, 0x55FFFF),
    BUILDER("Builder", 0x00AAAA, 0x55FFFF),
    GAME_MASTER("Game Master", 0x00AAAA, 0x55FFFF),
    MODERATOR("Mod", 0xFFAA00, 0xFFFF55),
    WEBDEV("Web Dev", 0xAA0000, 0xFF5555),
    ADMINISTRATOR("Admin", 0xAA0000, 0xFF5555);

    private final String readableString;
    private final int nameColor;
    private final int rankColor;

    PlayerRank(String readableString, int nameColor, int rankColor) {
        this.readableString = readableString;
        this.nameColor = nameColor;
        this.rankColor = rankColor;
    }

    public String getReadableString() {
        return this.readableString;
    }

    public int getNameColor() {
        return this.nameColor;
    }

    public int getRankColor() {
        return this.rankColor;
    }

    public static PlayerRank fromString(String rankName) {
        if (rankName == null) {
            return UNKNOWN;
        }

        rankName = rankName.replaceAll(" ", "_");

        for (PlayerRank rank : PlayerRank.values()) {
            if (rank.name().equalsIgnoreCase(rankName)) {
                return rank;
            }
        }

        return PlayerRank.UNKNOWN;
    }

}
