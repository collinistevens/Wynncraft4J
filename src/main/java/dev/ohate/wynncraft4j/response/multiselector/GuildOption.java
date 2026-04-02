package dev.ohate.wynncraft4j.response.multiselector;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;

@Data
@Setter(AccessLevel.NONE)
public class GuildOption {

    private String name;
    private String prefix;
    private int level;
    private int members;
    private Instant created;

}
