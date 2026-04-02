package dev.ohate.wynncraft4j.response.guild.banner;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
public class BannerLayer {

    @SerializedName("colour")
    private BannerColor color;
    private BannerPattern pattern;

}
