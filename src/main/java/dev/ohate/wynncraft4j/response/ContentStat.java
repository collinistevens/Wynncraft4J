package dev.ohate.wynncraft4j.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Map;

@Data
@Setter(AccessLevel.NONE)
public class ContentStat<T> {

    private int total;
    private Map<T, Integer> list;

}
