package dev.ohate.wynncraft4j.response.leaderboards;

import java.util.Map;

public abstract class LeaderboardEntry {

    private String name;
    private String uuid;
    private long score;
    private Map<LeaderboardMetadata, Double> metadata;

    public String getName() {
        return this.name;
    }

    public String getUuid() {
        return this.uuid;
    }

    public long getScore() {
        return this.score;
    }

    public Map<LeaderboardMetadata, Double> getMetadata() {
        return this.metadata;
    }

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
