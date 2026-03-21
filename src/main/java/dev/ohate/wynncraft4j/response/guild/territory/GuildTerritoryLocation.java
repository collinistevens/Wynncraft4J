package dev.ohate.wynncraft4j.response.guild.territory;

public class GuildTerritoryLocation {

    private int[] start;
    private int[] end;

    public int startX() {
        return this.start[0];
    }

    public int startY() {
        return this.start[1];
    }

    public int endX() {
        return this.end[0];
    }

    public int endY() {
        return this.end[1];
    }

}
