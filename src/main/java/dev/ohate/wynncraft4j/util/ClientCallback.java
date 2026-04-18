package dev.ohate.wynncraft4j.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.ohate.wynncraft4j.response.WynnResponse;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static dev.ohate.wynncraft4j.util.GsonUtil.GSON;

public class ClientCallback<T> implements Callback {

    private final CompletableFuture<WynnResponse<T>> future = new CompletableFuture<>();

    private final Type type;

    public ClientCallback(Type type) {
        this.type = type;
    }

    public CompletableFuture<WynnResponse<T>> getFuture() {
        return this.future;
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        this.future.completeExceptionally(e);
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) {
        try (ResponseBody responseBody = response.body()) {
            String content = responseBody.string();

            if (response.isSuccessful()) {
                T data = GSON.fromJson(content, this.type);
                this.future.complete(WynnResponse.success(response.code(), data));
                return;
            }

            JsonObject body = JsonParser.parseString(content).getAsJsonObject();

            String error = body.has("detail") ? body.get("detail").getAsString() : "An unknown error has occurred.";
            Object metadata = null;

            // Multi-selector structures are different
            if (response.code() == 300) {
                if (body.has("error")) { // Player
                    metadata = GSON.fromJson(body.get("objects").getAsJsonObject(), GsonUtil.PLAYER_OPTION_TYPE);
                } else { // Guild
                    metadata = GSON.fromJson(body, GsonUtil.PLAYER_OPTION_TYPE);
                    error = "Query returned multiple results.";
                }
            }

            this.future.complete(WynnResponse.error(response.code(), error, metadata));
        } catch (Throwable e) {
            this.future.completeExceptionally(e);
        }
    }

}
