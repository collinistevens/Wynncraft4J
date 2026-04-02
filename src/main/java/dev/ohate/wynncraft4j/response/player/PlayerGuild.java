package dev.ohate.wynncraft4j.response.player;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
@Setter(AccessLevel.NONE)
public class PlayerGuild {

    private UUID uuid;
    private String name;
    private String prefix;
    private String rank;
    private String rankStars;

}
