package dev.ohate.wynncraft4j.response.guild.banner;

import com.google.gson.annotations.SerializedName;

public class BannerLayer {

    @SerializedName("colour") private BannerColor color;
    private BannerPattern pattern;

    public BannerLayer(BannerColor color, BannerPattern pattern) {
        this.color = color;
        this.pattern = pattern;
    }

    public BannerColor getColor() {
        return this.color;
    }

    public BannerPattern getPattern() {
        return this.pattern;
    }

}
