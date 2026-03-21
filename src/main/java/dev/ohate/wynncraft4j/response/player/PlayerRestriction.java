package dev.ohate.wynncraft4j.response.player;

import com.google.gson.annotations.SerializedName;

public enum PlayerRestriction {
    @SerializedName("mainAccess") MAIN_ACCESS,
    @SerializedName("characterDataAccess") CHARACTER_DATA_ACCESS,
    @SerializedName("characterBuildAccess") CHARACTER_BUILD_ACCESS,
    @SerializedName("onlineStatus") ONLINE_STATUS
}
