package dev.ohate.wynncraft4j.response.player.character;

import dev.ohate.wynncraft4j.response.ContentStat;
import dev.ohate.wynncraft4j.response.player.PlayerCombatStat;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class Character {

    private CharacterType type;
    @Nullable private CharacterSkin reskin;
    @Nullable private String nickname;
    private int level;
    private long xp;
    private int xpPercent;
    private int totalLevel;
    private List<CharacterGamemode> gamemode;
    private List<CharacterStat> removedStat;
    @Nullable private Integer lootruns;
    @Nullable private Map<Profession, ProfessionStat> professions;
    @Nullable private Integer deaths;
    @Nullable private Integer chestsFound;
    @Nullable private Integer contentCompletion;
    @Nullable private ContentStat dungeons;
    @Nullable private Integer discoveries;
    @Nullable private Integer itemsIdentified;
    @Nullable private Integer wars;
    @Nullable private Float playtime;
    @Nullable private Integer caves;
    @Nullable private List<String> quests;
    @Nullable private ContentStat raids;
    @Nullable private PlayerCombatStat pvp;
    @Nullable private Integer blocksWalked;
    @Nullable private Integer worldEvents;
    @Nullable private SkillPoints skillPoints;
    @Nullable private Integer logins;
    @Nullable private Integer mobsKilled;

    public CharacterType getType() {
        return this.type;
    }

    @Nullable
    public CharacterSkin getReskin() {
        return this.reskin;
    }

    @Nullable
    public String getNickname() {
        return this.nickname;
    }

    public int getLevel() {
        return this.level;
    }

    public long getXp() {
        return this.xp;
    }

    public int getXpPercent() {
        return this.xpPercent;
    }

    public int getTotalLevel() {
        return this.totalLevel;
    }

    public List<CharacterGamemode> getGamemode() {
        return this.gamemode;
    }

    public List<CharacterStat> getRemovedStat() {
        return this.removedStat;
    }

    public boolean isStatRemoved(CharacterStat stat) {
        return this.removedStat.contains(stat);
    }

    @Nullable
    public Integer getLootruns() {
        return this.lootruns;
    }

    @Nullable
    public Map<Profession, ProfessionStat> getProfessions() {
        return this.professions;
    }

    @Nullable
    public Integer getDeaths() {
        return this.deaths;
    }

    @Nullable
    public Integer getChestsFound() {
        return this.chestsFound;
    }

    @Nullable
    public Integer getContentCompletion() {
        return this.contentCompletion;
    }

    @Nullable
    public ContentStat getDungeons() {
        return this.dungeons;
    }

    @Nullable
    public Integer getDiscoveries() {
        return this.discoveries;
    }

    @Nullable
    public Integer getItemsIdentified() {
        return this.itemsIdentified;
    }

    @Nullable
    public Integer getWars() {
        return this.wars;
    }

    @Nullable
    public Float getPlaytime() {
        return this.playtime;
    }

    @Nullable
    public Integer getCaves() {
        return this.caves;
    }

    @Nullable
    public List<String> getQuests() {
        return this.quests;
    }

    @Nullable
    public ContentStat getRaids() {
        return this.raids;
    }

    @Nullable
    public PlayerCombatStat getPvp() {
        return this.pvp;
    }

    @Nullable
    public Integer getBlocksWalked() {
        return this.blocksWalked;
    }

    @Nullable
    public Integer getWorldEvents() {
        return this.worldEvents;
    }

    @Nullable
    public SkillPoints getSkillPoints() {
        return this.skillPoints;
    }

    @Nullable
    public Integer getLogins() {
        return this.logins;
    }

    @Nullable
    public Integer getMobsKilled() {
        return this.mobsKilled;
    }

}
