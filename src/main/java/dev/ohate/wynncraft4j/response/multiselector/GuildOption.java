package dev.ohate.wynncraft4j.response.multiselector;

import java.time.Instant;

public class GuildOption {

    private String name;
    private String prefix;
    private int level;
    private int members;
    private Instant created;

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMembers() {
        return this.members;
    }

    public Instant getCreated() {
        return this.created;
    }

}
