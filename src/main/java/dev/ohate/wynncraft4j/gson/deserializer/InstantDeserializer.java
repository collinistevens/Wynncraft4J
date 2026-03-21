package dev.ohate.wynncraft4j.gson.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;

public class InstantDeserializer implements JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        return Instant.parse(json.getAsString());
    }

}
