package dev.ohate.wynncraft4j.gson.adapter;

import com.google.gson.JsonObject;
import dev.ohate.wynncraft4j.gson.PreprocessingTypeAdapterFactory;
import dev.ohate.wynncraft4j.response.leaderboards.type.GuildLeaderboard;

public class GuildLeaderboardAdapter extends PreprocessingTypeAdapterFactory {

    public GuildLeaderboardAdapter() {
        super(GuildLeaderboard.class, json -> {
            JsonObject root = json.getAsJsonObject();

            if (root.has("metadata")) return json;

            JsonObject metadata = new JsonObject();

            metadata.addProperty("level", root.get("level").getAsInt());
            metadata.addProperty("xp", root.get("xp").getAsLong());
            metadata.addProperty("territories", root.get("territories").getAsInt());
            metadata.addProperty("wars", root.get("wars").getAsInt());

            root.add("metadata", metadata);

            return root;
        });
    }

}
