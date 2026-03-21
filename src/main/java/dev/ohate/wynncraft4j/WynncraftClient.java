package dev.ohate.wynncraft4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.ohate.wynncraft4j.exception.WynncraftException;
import dev.ohate.wynncraft4j.gson.adapter.GuildLeaderboardAdapter;
import dev.ohate.wynncraft4j.gson.deserializer.InstantDeserializer;
import dev.ohate.wynncraft4j.gson.deserializer.WynncraftExceptionDeserializer;
import dev.ohate.wynncraft4j.response.OnlinePlayers;
import dev.ohate.wynncraft4j.response.guild.Guild;
import dev.ohate.wynncraft4j.response.guild.GuildSummary;
import dev.ohate.wynncraft4j.response.guild.territory.GuildTerritory;
import dev.ohate.wynncraft4j.response.leaderboards.Leaderboard;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import dev.ohate.wynncraft4j.response.leaderboards.type.GuildLeaderboard;
import dev.ohate.wynncraft4j.response.leaderboards.type.PlayerLeaderboard;
import dev.ohate.wynncraft4j.response.player.Player;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class WynncraftClient {

    private final static Type GUILD_LIST_TYPE = new TypeToken<Map<UUID, GuildSummary>>() {
    }.getType();
    private final static Type GUILD_TERRITORY_TYPE = new TypeToken<Map<String, GuildTerritory>>() {
    }.getType();

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapterFactory(new GuildLeaderboardAdapter())
            .registerTypeAdapter(Instant.class, new InstantDeserializer())
            .registerTypeAdapter(WynncraftException.class, new WynncraftExceptionDeserializer())
            .create();

    private static final String API_URL = "https://api.wynncraft.com/v3/{0}";
    private static final String USER_AGENT = "Wynncraft4J/Dev (@ohate)";

    private final String apiKey;
    private final OkHttpClient client;

    public WynncraftClient(String apiKey, Consumer<OkHttpClient.Builder> builderConsumer) {
        this.apiKey = apiKey;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (builderConsumer != null) {
            builderConsumer.accept(builder);
        }

        this.client = builder.build();
    }

    public WynncraftClient() {
        this("", null);
    }

    // Player Endpoints
    public CompletableFuture<Player> getPlayer(String player) {
        return get(Player.class, "player/{0}?fullResult", player);
    }

    public CompletableFuture<OnlinePlayers> getOnlinePlayers() {
        return get(OnlinePlayers.class, "player?identifier=username");
    }

    // Guild Endpoints
    public CompletableFuture<Guild> getGuildByUuid(String guild) {
        return get(Guild.class, "guild/uuid/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<Guild> getGuildByName(String guild) {
        return get(Guild.class, "guild/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<Guild> getGuildByPrefix(String guild) {
        return get(Guild.class, "guild/prefix/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<Map<UUID, GuildSummary>> getGuildList() {
        return get(GUILD_LIST_TYPE, "guild/list/guild?identifier=uuid");
    }

    public CompletableFuture<Map<String, GuildTerritory>> getGuildTerritory() {
        return get(GUILD_TERRITORY_TYPE, "guild/list/territory");
    }

    // Leaderboard Endpoints
    public CompletableFuture<? extends Leaderboard> getLeaderboard(LeaderboardType type, int resultLimit) {
        Class<? extends Leaderboard> responseType = type.isGuild() ?
                GuildLeaderboard.class :
                PlayerLeaderboard.class;

        return get(responseType, "leaderboard/{0}?resultLimit={1}", type.getKey(), resultLimit);
    }

    private <T> CompletableFuture<T> get(Type type, String endpointTemplate, Object... arguments) {
        Request request = createRequest(MessageFormat.format(endpointTemplate, arguments));
        return execute(type, request);
    }

    private <T> CompletableFuture<T> get(Class<T> type, String endpointTemplate, Object... arguments) {
        return get((Type) type, endpointTemplate, arguments);
    }

    private <T> CompletableFuture<T> createCallback(Type type) {
        CompletableFuture<T> future = new CompletableFuture<T>();

        Callback callback = new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                try (ResponseBody body = response.body()) {
                    String content = body.string();
                    String url = call.request().url().toString();

                    if (!response.isSuccessful()) {
                        WynncraftException exception = GSON.fromJson(content, WynncraftException.class);
                        exception.setUrl(url);
                        future.completeExceptionally(exception);
                        return;
                    }

                    T value = GSON.fromJson(content, type);
                    future.complete(value);
                } catch (Throwable e) {
                    future.completeExceptionally(e);
                }
            }
        };

        return future;
    }

    private Request createRequest(String endpoint, Consumer<Request.Builder> builderConsumer) {
        Request.Builder builder = new Request.Builder()
                .url(MessageFormat.format(API_URL, endpoint))
                .header("Content-Type", "application/json")
                .header("User-Agent", USER_AGENT)
                .get();

        if (this.apiKey != null && !this.apiKey.isEmpty()) {
            builder.header("Authorization", "Bearer " + this.apiKey);
        }

        if (builderConsumer != null) {
            builderConsumer.accept(builder);
        }

        return builder.build();
    }

    private Request createRequest(String endpoint) {
        return createRequest(endpoint, null);
    }

    private <T> CompletableFuture<T> execute(Type type, Request request) {
        CompletableFuture<T> future = new CompletableFuture<T>();

        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                try (ResponseBody body = response.body()) {
                    String content = body.string();
                    String url = call.request().url().toString();

                    if (!response.isSuccessful()) {
                        WynncraftException exception = GSON.fromJson(content, WynncraftException.class);
                        exception.setUrl(url);
                        future.completeExceptionally(exception);
                        return;
                    }

                    T value = GSON.fromJson(content, type);
                    future.complete(value);
                } catch (Throwable e) {
                    future.completeExceptionally(e);
                }
            }
        });

        return future;
    }

}
