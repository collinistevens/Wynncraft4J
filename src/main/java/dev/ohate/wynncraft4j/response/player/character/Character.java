package dev.ohate.wynncraft4j.response.player.character;

import dev.ohate.wynncraft4j.response.ContentStat;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import dev.ohate.wynncraft4j.response.player.DungeonStat;
import dev.ohate.wynncraft4j.response.player.DungeonType;
import dev.ohate.wynncraft4j.response.player.PlayerCombatStat;
import dev.ohate.wynncraft4j.response.player.RaidType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Data
@Setter(AccessLevel.NONE)
public class Character {

    private CharacterType type;
    @Nullable
    private CharacterSkin reskin;
    @Nullable
    private String nickname;
    private int level;
    private long xp;
    private int xpPercent;
    private int totalLevel;
    private List<CharacterGamemode> gamemode;
    private List<CharacterStat> removedStat;
    @Nullable
    private Integer lootruns;
    @Nullable
    private Map<LeaderboardType, ProfessionStat> professions;
    @Nullable
    private Integer deaths;
    @Nullable
    private Integer chestsFound;
    @Nullable
    private Integer contentCompletion;
    @Nullable
    private ContentStat<String> dungeons;
    @Nullable
    private Integer discoveries;
    @Nullable
    private Integer itemsIdentified;
    @Nullable
    private Integer wars;
    @Nullable
    private Float playtime;
    @Nullable
    private Integer caves;
    @Nullable
    private List<String> quests;
    @Nullable
    private ContentStat<RaidType> raids;
    @Nullable
    private PlayerCombatStat pvp;
    @Nullable
    private Integer blocksWalked;
    @Nullable
    private Integer worldEvents;
    @Nullable
    private SkillPoints skillPoints;
    @Nullable
    private Integer logins;
    @Nullable
    private Integer mobsKilled;

    public Map<DungeonType, DungeonStat> compileDungeons() {
        Map<DungeonType, DungeonStat> dungeons = new LinkedHashMap<>();
        Map<String, Integer> dungeonList = this.dungeons.getList();

        for (DungeonType type : DungeonType.values()) {
            int normal = dungeonList.getOrDefault(type.getName(), 0);
            int corrupted = dungeonList.getOrDefault("Corrupted " + type.getName(), 0);

            if (normal != 0 || corrupted != 0) {
                dungeons.put(type, new DungeonStat(normal, corrupted));
            }
        }

        return dungeons;
    }

    public List<CharacterGamemode> getSortedGamemodes() {
        List<CharacterGamemode> gamemodes = new ArrayList<>(this.gamemode);
        gamemodes.sort(Comparator.comparingInt(CharacterGamemode::ordinal));

        if (gamemodes.contains(CharacterGamemode.ULTIMATE_IRONMAN)) {
            gamemodes.remove(CharacterGamemode.IRONMAN);
        }

        return gamemodes;
    }


    public boolean isStatRemoved(CharacterStat stat) {
        return this.removedStat.contains(stat);
    }

}
