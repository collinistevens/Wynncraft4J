package dev.ohate.wynncraft4j.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OnlinePlayers {

    private int total;
    private Map<String, String> players;

    public Map<String, Map<Integer, Integer>> parseServerCounts() {
        Map<String, Map<Integer, Integer>> result = new HashMap<>();

        for (String server : this.players.values()) {
            int splitIndex = 0;
            while (splitIndex < server.length() && !Character.isDigit(server.charAt(splitIndex))) {
                splitIndex++;
            }

            String region = server.substring(0, splitIndex);
            int number = Integer.parseInt(server.substring(splitIndex));

            result.computeIfAbsent(region, r -> new HashMap<>())
                    .merge(number, 1, Integer::sum);
        }

        // Sort regions by total player count (descending)
        return result.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int totalA = a.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int totalB = b.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(totalB, totalA);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    public int getTotal() {
        return this.total;
    }

    public Map<String, String> getPlayers() {
        return this.players;
    }

}
