package dev.ohate.wynncraft4j.gson.deserializer;

import com.google.gson.*;
import dev.ohate.wynncraft4j.exception.WynncraftException;

import java.lang.reflect.Type;

public class WynncraftExceptionDeserializer implements JsonDeserializer<WynncraftException> {

    @Override
    public WynncraftException deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject root = json.getAsJsonObject();
        return new WynncraftException(
                root.get("code").getAsInt(),
                root.get("error").getAsString(),
                root.get("detail").getAsString()
        );
    }

}
