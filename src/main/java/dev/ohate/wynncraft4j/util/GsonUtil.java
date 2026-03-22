package dev.ohate.wynncraft4j.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.ohate.wynncraft4j.exception.WynncraftException;
import dev.ohate.wynncraft4j.gson.adapter.GuildLeaderboardEntryAdapter;
import dev.ohate.wynncraft4j.gson.adapter.InstantAdapter;
import dev.ohate.wynncraft4j.gson.deserializer.WynncraftExceptionDeserializer;
import dev.ohate.wynncraft4j.response.guild.GuildSummary;
import dev.ohate.wynncraft4j.response.guild.territory.GuildTerritory;
import dev.ohate.wynncraft4j.response.leaderboards.type.GuildLeaderboardEntry;
import dev.ohate.wynncraft4j.response.leaderboards.type.PlayerLeaderboardEntry;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class GsonUtil {

    public static final Type GUILD_LIST_TYPE = mapOf(UUID.class, GuildSummary.class);
    public static final Type GUILD_TERRITORY_LIST_TYPE = mapOf(String.class, GuildTerritory.class);
    public static final Type GUILD_LEADERBOARD_TYPE = mapOf(Integer.class, GuildLeaderboardEntry.class);
    public static final Type PLAYER_LEADERBOARD_TYPE = mapOf(Integer.class, PlayerLeaderboardEntry.class);

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapterFactory(new GuildLeaderboardEntryAdapter())
            .registerTypeAdapter(Instant.class, new InstantAdapter())
            .registerTypeAdapter(WynncraftException.class, new WynncraftExceptionDeserializer())
            .create();

    private static Type mapOf(Class<?> key, Class<?> value) {
        return TypeToken.getParameterized(Map.class, key, value).getType();
    }

}
