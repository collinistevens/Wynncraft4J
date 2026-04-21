package dev.ohate.wynncraft4j.response.player;

import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import dev.ohate.wynncraft4j.response.player.character.Character;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.*;

/**
 * Fields that can be null via privacy settings:
 * activeCharacter, firstJoin, lastJoin, playtime, globalData, characters
 */

@Data
@Setter(AccessLevel.NONE)
public class Player implements PlayerRankProvider {

    private UUID uuid;
    private String username;
    private boolean online;
    private String server;
    @Nullable
    private UUID activeCharacter;
    @Nullable
    private String nickname;
    private String rank;
    @Nullable
    private String supportRank;
    private boolean veteran;
    @Nullable
    private Instant firstJoin;
    @Nullable
    private Instant lastJoin;
    @Nullable
    private Float playtime;
    @Nullable
    private PlayerGuild guild;
    @Nullable
    private PlayerGlobalData globalData;
    private Map<LeaderboardType, Integer> ranking;
    private Map<LeaderboardType, Integer> previousRanking;
    @Nullable
    private Map<UUID, Character> characters;
    private Map<PlayerRestriction, Boolean> restrictions;

    public List<Character> getTopCharacters(int limit) {
        if (this.characters == null) {
            return Collections.emptyList();
        }

        return this.characters
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Character::getTotalLevel).reversed())
                .limit(limit)
                .toList();
    }

    public Map<LeaderboardType, Integer> compileRankings(List<LeaderboardType> types) {
        Map<LeaderboardType, Integer> rankings = new LinkedHashMap<>();

        for (LeaderboardType type : types) {
            Integer position = this.ranking.get(type);

            if (position != null) {
                rankings.put(type, position);
            }
        }

        return rankings;
    }

    public boolean hasRankings(List<LeaderboardType> leaderboards) {
        for (LeaderboardType type : leaderboards) {
            if (!this.ranking.containsKey(type)) {
                return false;
            }
        }

        return true;
    }

}
