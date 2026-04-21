package dev.ohate.wynncraft4j.response.leaderboards;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Map;

@Data
@Setter(AccessLevel.NONE)
public abstract class LeaderboardEntry {

    private String name;
    private String uuid;
    private long score;
    private Map<LeaderboardMetadata, String> metadata;

    public boolean hasMetadata(LeaderboardMetadata... metadata) {
        for (LeaderboardMetadata key : metadata) {
            if (!this.metadata.containsKey(key)) return false;
        }

        return true;
    }

    public boolean isRedacted() {
        return this.uuid.equals("redacted");
    }

}
