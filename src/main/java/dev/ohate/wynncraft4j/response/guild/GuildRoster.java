package dev.ohate.wynncraft4j.response.guild;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static dev.ohate.wynncraft4j.response.guild.GuildRole.*;

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

    public Map<GuildRole, Map<UUID, GuildMember>> asRoleMap() {
        Map<GuildRole, Map<UUID, GuildMember>> roleMap = new LinkedHashMap<>();

        roleMap.put(OWNER, this.owner);
        roleMap.put(CHIEF, this.chief);
        roleMap.put(STRATEGIST, this.strategist);
        roleMap.put(CAPTAIN, this.captain);
        roleMap.put(RECRUITER, this.recruiter);
        roleMap.put(RECRUIT, this.recruit);

        return roleMap;
    }

}
