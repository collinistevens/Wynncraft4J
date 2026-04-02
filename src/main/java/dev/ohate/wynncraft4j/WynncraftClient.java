package dev.ohate.wynncraft4j;

import dev.ohate.wynncraft4j.response.OnlinePlayers;
import dev.ohate.wynncraft4j.response.WynnResponse;
import dev.ohate.wynncraft4j.response.guild.Guild;
import dev.ohate.wynncraft4j.response.guild.GuildSummary;
import dev.ohate.wynncraft4j.response.guild.TerritoryResponse;
import dev.ohate.wynncraft4j.response.guild.territory.GuildTerritory;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardEntry;
import dev.ohate.wynncraft4j.response.leaderboards.LeaderboardType;
import dev.ohate.wynncraft4j.response.player.Player;
import dev.ohate.wynncraft4j.util.ClientCallback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static dev.ohate.wynncraft4j.util.GsonUtil.*;

public class WynncraftClient {

    private static final String WYNNCRAFT_API_URL = "https://api.wynncraft.com/v3/{0}";
    private static final String ATHENA_API_URL = "https://athena.wynntils.com/cache/get/{0}";
    private static final String USER_AGENT = "Wynncraft4J/1.0";

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

    public WynncraftClient(String apiKey) {
        this(apiKey, null);
    }

    public WynncraftClient() {
        this(null);
    }

    // Player Endpoints
    public CompletableFuture<WynnResponse<Player>> getPlayer(String player) {
        return get(Player.class, "player/{0}?fullResult", player);
    }

    public CompletableFuture<WynnResponse<OnlinePlayers>> getOnlinePlayers() {
        return get(OnlinePlayers.class, "player?identifier=username");
    }

    // Guild Endpoints
    public CompletableFuture<WynnResponse<Guild>> getGuildByUuid(String guild) {
        return get(Guild.class, "guild/uuid/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<WynnResponse<Guild>> getGuildByName(String guild) {
        return get(Guild.class, "guild/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<WynnResponse<Guild>> getGuildByPrefix(String guild) {
        return get(Guild.class, "guild/prefix/{0}?identifier=uuid", guild);
    }

    public CompletableFuture<WynnResponse<Map<UUID, GuildSummary>>> getGuildList() {
        return get(GUILD_LIST_TYPE, "guild/list/guild?identifier=uuid");
    }

    public CompletableFuture<WynnResponse<TerritoryResponse>> getGuildTerritoryList() {
        return getAthena(TerritoryResponse.class, "territoryList");
    }

    // Leaderboard Endpoints
    public CompletableFuture<WynnResponse<Map<Integer, LeaderboardEntry>>> getLeaderboard(LeaderboardType type, int resultLimit) {
        return get(type.isGuild() ?
                        GUILD_LEADERBOARD_TYPE :
                        PLAYER_LEADERBOARD_TYPE,
                "leaderboards/{0}?resultLimit={1}",
                type.getKey(),
                resultLimit
        );
    }

    private String formatUrl(String baseUrl, String endpoint, Object... arguments) {
        return MessageFormat.format(MessageFormat.format(baseUrl, endpoint), arguments);
    }

    private <T> CompletableFuture<WynnResponse<T>> getAthena(Type type, String endpoint, Object... arguments) {
        return execute(type, createRequest(formatUrl(ATHENA_API_URL, endpoint, arguments)).build());
    }

    private <T> CompletableFuture<WynnResponse<T>> getAthena(Class<T> type, String endpoint, Object... arguments) {
        return getAthena((Type) type, endpoint, arguments);
    }

    private <T> CompletableFuture<WynnResponse<T>> get(Type type, String endpoint, Object... arguments) {
        return execute(type, createRequest(formatUrl(WYNNCRAFT_API_URL, endpoint, arguments)).build());
    }

    private <T> CompletableFuture<WynnResponse<T>> get(Class<T> type, String endpointTemplate, Object... arguments) {
        return get((Type) type, endpointTemplate, arguments);
    }

    private Request.Builder createRequest(String url) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get()
                .header("Content-Type", "application/json")
                .header("User-Agent", USER_AGENT);

        if (this.apiKey != null && !this.apiKey.isEmpty()) {
            builder.header("Authorization", "Bearer " + this.apiKey);
        }

        return builder;
    }

    private <T> CompletableFuture<WynnResponse<T>> execute(Type type, Request request) {
        ClientCallback<T> callback = new ClientCallback<>(type);

        this.client.newCall(request).enqueue(callback);

        return callback.getFuture();
    }

}
