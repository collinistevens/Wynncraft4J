package dev.ohate.wynncraft4j.response.leaderboards.type;

import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardEntry;
import dev.ohate.wynncraft4j.response.player.PlayerRankProvider;
import org.jetbrains.annotations.Nullable;

public class PlayerLeaderboardEntry extends LeaderboardEntry implements PlayerRankProvider {

    private String rank;
    private String supportRank;

    // if raidSr or raidCompletion or warsCompletion or globalPlayerContent these are null, if isRedacted is true these are "redacted"
    @Nullable private String characterUuid;
    @Nullable private String characterType;

    @Nullable
    public String getCharacterUuid() {
        return this.characterUuid;
    }

    @Nullable
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public String getRank() {
        return this.rank;
    }

    @Override
    public String getSupportRank() {
        return this.supportRank;
    }

}
