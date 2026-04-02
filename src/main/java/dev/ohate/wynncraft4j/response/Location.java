package dev.ohate.wynncraft4j.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Location {

    private int startX;
    private int startZ;
    private int endX;
    private int endZ;

}
