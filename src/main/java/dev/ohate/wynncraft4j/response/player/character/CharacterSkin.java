package dev.ohate.wynncraft4j.response.player.character;

public enum CharacterSkin {
    HUNTER("Hunter"),
    KNIGHT("Knight"),
    NINJA("Ninja"),
    DARKWIZARD("Dark Wizard"),
    SKYSEER("Skyseer");

    private final String readableString;

    CharacterSkin(String readableString) {
        this.readableString = readableString;
    }

    public String getReadableString() {
        return this.readableString;
    }

}
