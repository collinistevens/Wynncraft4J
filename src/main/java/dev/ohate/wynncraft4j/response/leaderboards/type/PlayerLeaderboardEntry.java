package dev.ohate.wynncraft4j.response.leaderboards.type;

import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardEntry;
import dev.ohate.wynncraft4j.response.player.PlayerRankProvider;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;


@Data
@Setter(AccessLevel.NONE)
@EqualsAndHashCode(callSuper = true)
public class PlayerLeaderboardEntry extends LeaderboardEntry implements PlayerRankProvider {

    private String rank;
    private String supportRank;

    // TODO -> Shift to metadata
    // if raidSr or raidCompletion or warsCompletion or globalPlayerContent these are null, if isRedacted is true these are "redacted"
    @Nullable private String characterUuid;
    @Nullable private String characterType;

}
