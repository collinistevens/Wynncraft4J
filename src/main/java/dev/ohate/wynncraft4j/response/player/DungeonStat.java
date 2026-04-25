package dev.ohate.wynncraft4j.response.player;

public class DungeonStat {

    private final int normal;
    private final int corrupted;

    public DungeonStat(int normal, int corrupted) {
        this.normal = normal;
        this.corrupted = corrupted;
    }

    public int getNormal() {
        return this.normal;
    }

    public int getCorrupted() {
        return this.corrupted;
    }

}
