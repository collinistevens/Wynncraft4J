package dev.ohate.wynncraft4j.response;

import java.util.Map;

public class ContentStat {

    private int total;
    private Map<String, Integer> list;

    public int getTotal() {
        return this.total;
    }

    public Map<String, Integer> getList() {
        return this.list;
    }

}
