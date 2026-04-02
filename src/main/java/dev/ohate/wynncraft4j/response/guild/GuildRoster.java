package dev.ohate.wynncraft4j.response.guild;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Data
@Setter(AccessLevel.NONE)
public class GuildRoster {

    private int total;
    private Map<UUID, GuildMember> owner;
    private Map<UUID, GuildMember> chief;
    private Map<UUID, GuildMember> strategist;
    private Map<UUID, GuildMember> captain;
    private Map<UUID, GuildMember> recruiter;
    private Map<UUID, GuildMember> recruit;

}
