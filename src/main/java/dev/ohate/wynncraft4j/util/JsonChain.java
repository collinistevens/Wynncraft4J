package dev.ohate.wynncraft4j.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonChain {

    private final JsonObject root;

    public JsonChain() {
        this.root = new JsonObject();
    }

    public JsonChain add(String property, String value) {
        this.root.addProperty(property, value);
        return this;
    }

    public JsonChain add(String property, Number value) {
        this.root.addProperty(property, value);
        return this;
    }

    public JsonChain add(String property, Boolean value) {
        this.root.addProperty(property, value);
        return this;
    }

    public JsonChain add(String property, Character value) {
        this.root.addProperty(property, value);
        return this;
    }

    public JsonChain add(String property, JsonElement value) {
        this.root.add(property, value);
        return this;
    }

    public JsonObject build() {
        return this.root;
    }

}
