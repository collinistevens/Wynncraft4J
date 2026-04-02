package dev.ohate.wynncraft4j.response.player.character;

import lombok.Getter;

@Getter
public enum CharacterType {
    ARCHER("Archer"),
    WARRIOR("Warrior"),
    ASSASSIN("Assassin"),
    MAGE("Mage"),
    SHAMAN("Shaman");

    private final String readableString;

    CharacterType(String readableString) {
        this.readableString = readableString;
    }

}
