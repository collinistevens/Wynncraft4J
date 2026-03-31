package dev.ohate.wynncraft4j.response.leaderboards;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import static dev.ohate.wynncraft4j.response.leaderboards.LeaderboardMetadata.*;

public enum LeaderboardType {
    @SerializedName("guildLevel") GUILD_LEVEL("guildLevel", "Guild Level", "Level", true, LEVEL, TERRITORIES, WARS),
    @SerializedName("guildTerritories") GUILD_TERRITORIES("guildTerritories", "Guild Territories", "Territories", true, TERRITORIES, WARS, LEVEL),
    @SerializedName("guildWars") GUILD_WARS("guildWars", "Guild Wars", "Wars", true, WARS, TERRITORIES, LEVEL),

    @SerializedName("globalPlayerContent") GLOBAL_PLAYER_CONTENT("globalPlayerContent", "Global Total Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("playerContent") PLAYER_CONTENT("playerContent", "Total Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("warsCompletion") WARS_COMPLETION("warsCompletion", "War Completions", "Completion", PLAYTIME),

    @SerializedName("professionsGlobalLevel") PROFESSIONS_GLOBAL_LEVEL("professionsGlobalLevel", "Professions Global Level", "Level", XP, PLAYTIME),
    @SerializedName("professionsSoloLevel") PROFESSIONS_SOLO_LEVEL("professionsSoloLevel", "Professions Solo Level", "Level", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("combatGlobalLevel") COMBAT_GLOBAL_LEVEL("combatGlobalLevel", "Combat Global Level", "Level", XP, PLAYTIME),
    @SerializedName("combatSoloLevel") COMBAT_SOLO_LEVEL("combatSoloLevel", "Combat Solo Level", "Level", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("totalGlobalLevel") TOTAL_GLOBAL_LEVEL("totalGlobalLevel", "Total Global Level", "Level", XP, PLAYTIME),
    @SerializedName("totalSoloLevel") TOTAL_SOLO_LEVEL("totalSoloLevel", "Total Solo Level", "Total Level", XP, PLAYTIME),

    @SerializedName("alchemismLevel") ALCHEMISM_LEVEL("alchemismLevel", "Alchemism Level", "Level", XP, PLAYTIME),
    @SerializedName("armouringLevel") ARMOURING_LEVEL("armouringLevel", "Armouring Level", "Level", XP, PLAYTIME),
    @SerializedName("cookingLevel") COOKING_LEVEL("cookingLevel", "Cooking Level", "Level", XP, PLAYTIME),
    @SerializedName("farmingLevel") FARMING_LEVEL("farmingLevel", "Farming Level", "Level", XP, PLAYTIME),
    @SerializedName("fishingLevel") FISHING_LEVEL("fishingLevel", "Fishing Level", "Level", XP, PLAYTIME),
    @SerializedName("jewelingLevel") JEWELING_LEVEL("jewelingLevel", "Jeweling Level", "Level", XP, PLAYTIME),
    @SerializedName("miningLevel") MINING_LEVEL("miningLevel", "Mining Level", "Level", XP, PLAYTIME),
    @SerializedName("scribingLevel") SCRIBING_LEVEL("scribingLevel", "Scribing Level", "Level", XP, PLAYTIME),
    @SerializedName("tailoringLevel") TAILORING_LEVEL("tailoringLevel", "Tailoring Level", "Level", XP, PLAYTIME),
    @SerializedName("weaponsmithingLevel") WEAPONSMITHING_LEVEL("weaponsmithingLevel", "Weaponsmithing Level", "Level", XP, PLAYTIME),
    @SerializedName("woodcuttingLevel") WOOD_CUTTING_LEVEL("woodcuttingLevel", "Woodcutting Level", "Level", XP, PLAYTIME),
    @SerializedName("woodworkingLevel") WOODWORKING_LEVEL("woodworkingLevel", "Woodworking Level", "Level", XP, PLAYTIME),

    @SerializedName("craftsmanContent") CRAFTSMAN_CONTENT("craftsmanContent", "Craftsman Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("hardcoreContent") HARDCORE_CONTENT("hardcoreContent", "Hardcore Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("huntedContent") HUNTED_CONTENT("huntedContent", "Hunted Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("ironmanContent") IRONMAN_CONTENT("ironmanContent", "Ironman Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("ultimateIronmanContent") ULTIMATE_IRONMAN_CONTENT("ultimateIronmanContent", "Ultimate Ironman Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("hicContent") HIC_CONTENT("hicContent", "HIC Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("hichContent") HICH_CONTENT("hichContent", "HICH Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("huicContent") HUIC_CONTENT("huicContent", "HUIC Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("huichContent") HUICH_CONTENT("huichContent", "HUICH Content", "Content", TOTAL_LEVEL, XP, PLAYTIME),
    @SerializedName("hardcoreLegacyLevel") HARDCORE_LEGACY_LEVEL("hardcoreLegacyLevel", "Hardcore Legacy Level", "Level", TOTAL_LEVEL, XP, PLAYTIME),

    @SerializedName("grootslangCompletion") GROOTSLANG_COMPLETION("grootslangCompletion", "Grootslang Completion", "Completion", PLAYTIME),
    @SerializedName("grootslangSrPlayers") GROOTSLANG_SR_PLAYERS("grootslangSrPlayers", "Grootslang Sr Players", "Score", COMPLETIONS, GAMBITS),
    @SerializedName("grootslangSrGuilds") GROOTSLANG_SR_GUILDS("grootslangSrGuilds", "Grootslang Sr Guilds", "Sr Gained", true, COMPLETIONS, GAMBITS),
    @SerializedName("orphionCompletion") ORPHION_COMPLETION("orphionCompletion", "Orphion Completion", "Completion", PLAYTIME),
    @SerializedName("orphionSrPlayers") ORPHION_SR_PLAYERS("orphionSrPlayers", "Orphion Sr Players", "Score", COMPLETIONS, GAMBITS),
    @SerializedName("orphionSrGuilds") ORPHION_SR_GUILDS("orphionSrGuilds", "Orphion Sr Guilds", "Sr Gained", true, COMPLETIONS, GAMBITS),
    @SerializedName("colossusCompletion") COLOSSUS_COMPLETION("colossusCompletion", "Colossus Completion", "Completion", PLAYTIME),
    @SerializedName("colossusSrPlayers") COLOSSUS_SR_PLAYERS("colossusSrPlayers", "Colossus Sr Players", "Score", COMPLETIONS, GAMBITS),
    @SerializedName("colossusSrGuilds") COLOSSUS_SR_GUILDS("colossusSrGuilds", "Colossus Sr Guilds", "Sr Gained", true, COMPLETIONS, GAMBITS),
    @SerializedName("namelessCompletion") NAMELESS_COMPLETION("namelessCompletion", "Nameless Completion", "Completion", PLAYTIME),
    @SerializedName("namelessSrPlayers") NAMELESS_SR_PLAYERS("namelessSrPlayers", "Nameless Sr Players", "Score", COMPLETIONS, GAMBITS),
    @SerializedName("namelessSrGuilds") NAMELESS_SR_GUILDS("namelessSrGuilds", "Nameless Sr Guilds", "Sr Gained", true, COMPLETIONS, GAMBITS),;

    public static List<LeaderboardType> GUILD_LEADERBOARDS = Arrays.asList(
            GUILD_LEVEL,
            GUILD_TERRITORIES,
            GUILD_WARS
    );

    public static List<LeaderboardType> RAID_LEADERBOARDS = Arrays.asList(
            COLOSSUS_COMPLETION,
            COLOSSUS_SR_PLAYERS,
            COLOSSUS_SR_GUILDS,
            GROOTSLANG_COMPLETION,
            GROOTSLANG_SR_PLAYERS,
            GROOTSLANG_SR_GUILDS,
            ORPHION_COMPLETION,
            ORPHION_SR_PLAYERS,
            ORPHION_SR_GUILDS,
            NAMELESS_COMPLETION,
            NAMELESS_SR_PLAYERS,
            NAMELESS_SR_GUILDS
    );

    public static List<LeaderboardType> PROFFESSION_LEADERBOARDS = Arrays.asList(
            ALCHEMISM_LEVEL,
            ARMOURING_LEVEL,
            COOKING_LEVEL,
            FARMING_LEVEL,
            FISHING_LEVEL,
            JEWELING_LEVEL,
            MINING_LEVEL,
            SCRIBING_LEVEL,
            TAILORING_LEVEL,
            WEAPONSMITHING_LEVEL,
            WOOD_CUTTING_LEVEL,
            WOODWORKING_LEVEL
    );

    public static List<LeaderboardType> CONTENT_LEADERBOARDS = Arrays.asList(
            GLOBAL_PLAYER_CONTENT,
            PLAYER_CONTENT,
            WARS_COMPLETION,
            CRAFTSMAN_CONTENT,
            HARDCORE_CONTENT,
            HUNTED_CONTENT,
            IRONMAN_CONTENT,
            ULTIMATE_IRONMAN_CONTENT,
            HIC_CONTENT,
            HICH_CONTENT,
            HUIC_CONTENT,
            HUICH_CONTENT
    );

    public static List<LeaderboardType> TOTAL_LEVEL_LEADERBOARDS = Arrays.asList(
            PROFESSIONS_GLOBAL_LEVEL,
            PROFESSIONS_SOLO_LEVEL,
            COMBAT_GLOBAL_LEVEL,
            COMBAT_SOLO_LEVEL,
            TOTAL_GLOBAL_LEVEL,
            TOTAL_SOLO_LEVEL
    );

    private final String key;
    private final String readableString;
    private final String scoreString;
    private final boolean guild;
    private final LeaderboardMetadata[] metadata;

    LeaderboardType(String key, String readableString, String scoreString, boolean guild, LeaderboardMetadata... metadata) {
        this.key = key;
        this.readableString = readableString;
        this.scoreString = scoreString;
        this.guild = guild;
        this.metadata = metadata;
    }

    LeaderboardType(String key, String readableString, String scoreString, LeaderboardMetadata... metadata) {
        this(key, readableString, scoreString, false, metadata);
    }

    public String getKey() {
        return this.key;
    }

    public String getReadableString() {
        return this.readableString;
    }

    public String getScoreString() {
        return this.scoreString;
    }

    public boolean isGuild() {
        return this.guild;
    }

    public LeaderboardMetadata[] getMetadata() {
        return this.metadata;
    }

    @Override
    public String toString() {
        return this.key;
    }

}
