package dev.ohate.wynncraft4j.response.guild;

import java.util.Map;
import java.util.UUID;

public class GuildRoster {

    private int total;
    private Map<UUID, GuildMember> owner;
    private Map<UUID, GuildMember> chief;
    private Map<UUID, GuildMember> strategist;
    private Map<UUID, GuildMember> captain;
    private Map<UUID, GuildMember> recruiter;
    private Map<UUID, GuildMember> recruit;

    public int getTotal() {
        return this.total;
    }

    public Map<UUID, GuildMember> getOwner() {
        return this.owner;
    }

    public Map<UUID, GuildMember> getChief() {
        return this.chief;
    }

    public Map<UUID, GuildMember> getStrategist() {
        return this.strategist;
    }

    public Map<UUID, GuildMember> getCaptain() {
        return this.captain;
    }

    public Map<UUID, GuildMember> getRecruiter() {
        return this.recruiter;
    }

    public Map<UUID, GuildMember> getRecruit() {
        return this.recruit;
    }

}
