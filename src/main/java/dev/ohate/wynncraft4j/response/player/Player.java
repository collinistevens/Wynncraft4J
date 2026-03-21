package dev.ohate.wynncraft4j.response.player;

import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import dev.ohate.wynncraft4j.response.player.character.Character;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Player implements PlayerRankProvider {


    private UUID uuid;
    private String username;
    private boolean online;
    private String server;
    @Nullable private UUID activeCharacter; // nullable via privacy settings
    @Nullable private String nickname;
    private String rank;
    @Nullable private String supportRank;
    private boolean veteran;
    @Nullable private Instant firstJoin; // nullable via privacy settings
    @Nullable private Instant lastJoin; // nullable via privacy settings
    @Nullable private Float playtime; // nullable via privacy settings
    @Nullable private PlayerGuild guild;
    @Nullable private PlayerGlobalData globalData; // nullable via privacy settings
    private Map<LeaderboardType, Integer> ranking;
    private Map<LeaderboardType, Integer> previousRanking;
    @Nullable private Map<UUID, Character> characters; // nullable via privacy settings
    private Map<PlayerRestriction, Boolean> restrictions;

    public String getUsername() {
        return this.username;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public boolean isOnline() {
        return this.online;
    }

    public String getServer() {
        return this.server;
    }

    @Nullable
    public UUID getActiveCharacter() {
        return this.activeCharacter;
    }

    @Nullable
    public String getNickname() {
        return this.nickname;
    }

    @Override
    public String getRank() {
        return this.rank;
    }

    @Nullable
    @Override
    public String getSupportRank() {
        return this.supportRank;
    }

    public boolean isVeteran() {
        return this.veteran;
    }

    @Nullable
    public Instant getFirstJoin() {
        return this.firstJoin;
    }

    @Nullable
    public Instant getLastJoin() {
        return this.lastJoin;
    }

    @Nullable
    public Float getPlaytime() {
        return this.playtime;
    }

    @Nullable
    public PlayerGuild getGuild() {
        return this.guild;
    }

    @Nullable
    public PlayerGlobalData getGlobalData() {
        return this.globalData;
    }

    public Map<LeaderboardType, Integer> getRanking() {
        return this.ranking;
    }

    public boolean hasRankings(List<LeaderboardType> leaderboards) {
        for (LeaderboardType type : leaderboards) {
            if (!this.ranking.containsKey(type)) {
                return false;
            }
        }

        return true;
    }

    public Map<LeaderboardType, Integer> getPreviousRanking() {
        return this.previousRanking;
    }

    @Nullable
    public Map<UUID, Character> getCharacters() {
        return this.characters;
    }

    public Map<PlayerRestriction, Boolean> getRestrictions() {
        return this.restrictions;
    }

}
