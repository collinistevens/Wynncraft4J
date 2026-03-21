package dev.ohate.wynncraft4j.response.player;

public interface PlayerRankProvider {

    String getRank();
    String getSupportRank();

    default PlayerRank getActiveRank() {
        PlayerRank rank = PlayerRank.fromString(getRank());

        if (rank == PlayerRank.PLAYER && getSupportRank() != null) {
            rank = PlayerRank.fromString(getSupportRank());
        }

        return rank;
    }

}
