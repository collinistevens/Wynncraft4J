package dev.ohate.wynncraft4j.response.player;

import dev.ohate.wynncraft4j.response.ContentStat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PlayerGlobalData {

    private int contentCompletion;
    private int wars;
    private int totalLevel;
    private int mobsKilled;
    private int chestsFound;
    private ContentStat<String> dungeons;
    private ContentStat<RaidType> raids;
    private int worldEvents;
    private int lootruns;
    private int caves;
    private int completedQuests;
    private PlayerCombatStat pvp;

}
