package dev.ohate.wynncraft4j.response.guild.banner;

import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("base") private BannerColor color;
    private BannerLayer[] layers;

    public BannerColor getColor() {
        return this.color;
    }

    public BannerLayer[] getLayers() {
        return this.layers;
    }

}
