package dev.ohate.wynncraft4j.response.player;

import dev.ohate.wynncraft4j.response.ContentStat;

public class PlayerGlobalData {

    private int contentCompletion;
    private int wars;
    private int totalLevel;
    private int mobsKilled;
    private int chestsFound;
    private ContentStat dungeons;
    private ContentStat raids;
    private int worldEvents;
    private int lootruns;
    private int caves;
    private int completedQuests;
    private PlayerCombatStat pvp;

    public int getContentCompletion() {
        return this.contentCompletion;
    }

    public int getWars() {
        return this.wars;
    }

    public int getTotalLevel() {
        return this.totalLevel;
    }

    public int getMobsKilled() {
        return this.mobsKilled;
    }

    public int getChestsFound() {
        return this.chestsFound;
    }

    public ContentStat getDungeons() {
        return this.dungeons;
    }

    public ContentStat getRaids() {
        return this.raids;
    }

    public int getWorldEvents() {
        return this.worldEvents;
    }

    public int getLootruns() {
        return this.lootruns;
    }

    public int getCaves() {
        return this.caves;
    }

    public int getCompletedQuests() {
        return this.completedQuests;
    }

    public PlayerCombatStat getPvp() {
        return this.pvp;
    }

}
