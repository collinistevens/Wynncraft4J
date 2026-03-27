package dev.ohate.wynncraft4j.response;

import java.util.Map;

public class ContentStat<T> {

    private int total;
    private Map<T, Integer> list;

    public int getTotal() {
        return this.total;
    }

    public Map<T, Integer> getList() {
        return this.list;
    }

}
