package dev.ohate.wynncraft4j.gson.adapter;

import com.google.gson.JsonObject;
import dev.ohate.wynncraft4j.gson.PreprocessingTypeAdapterFactory;
import dev.ohate.wynncraft4j.response.leaderboards.type.PlayerLeaderboardEntry;

public class PlayerLeaderboardEntryAdapter extends PreprocessingTypeAdapterFactory {

    public PlayerLeaderboardEntryAdapter() {
        super(PlayerLeaderboardEntry.class, json -> {
            JsonObject root = json.getAsJsonObject();

            JsonObject metadata = root.has("metadata") ?
                    root.get("metadata").getAsJsonObject() :
                    new JsonObject();

            if (root.has("characterUuid")) {
                metadata.addProperty("characterUuid", root.get("characterUuid").getAsString());
            }

            if (root.has("characterType")) {
                metadata.addProperty("characterType", root.get("characterType").getAsString());
            }

            root.add("metadata", metadata);

            return json;
        });
    }

}
