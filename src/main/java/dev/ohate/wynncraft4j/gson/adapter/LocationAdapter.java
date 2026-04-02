package dev.ohate.wynncraft4j.gson.adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.ohate.wynncraft4j.gson.PreprocessingTypeAdapterFactory;
import dev.ohate.wynncraft4j.response.Location;
import dev.ohate.wynncraft4j.util.JsonChain;

public class LocationAdapter extends PreprocessingTypeAdapterFactory {

    public LocationAdapter() {
        super(Location.class, json -> {
            JsonObject root = json.getAsJsonObject();

            JsonArray startArr = root.get("start").getAsJsonArray();
            int startX = startArr.get(0).getAsInt();
            int startZ = startArr.get(1).getAsInt();

            JsonArray endArr = root.get("end").getAsJsonArray();
            int endX = endArr.get(0).getAsInt();
            int endZ = endArr.get(1).getAsInt();

            return new JsonChain()
                    .add("startX", Math.min(startX, endX))
                    .add("startZ", Math.min(startZ, endZ))
                    .add("endX", Math.max(startX, endX))
                    .add("endZ", Math.max(startZ, endZ))
                    .build();
        });
    }

}
