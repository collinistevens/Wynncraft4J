package dev.ohate.wynncraft4j.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
@Setter(AccessLevel.NONE)
public class OnlinePlayers {

    private static final Pattern SERVER_PATTERN = Pattern.compile("^([a-zA-Z]+)(\\d+)$");

    private int total;
    private Map<String, String> players;

    public Map<String, Map<Integer, Integer>> parseServerCounts() {
        Map<String, Map<Integer, Integer>> result = new HashMap<>();

        for (String server : this.players.values()) {
            if (server == null) continue;

            Matcher matcher = SERVER_PATTERN.matcher(server);
            if (!matcher.matches()) continue;

            String region = matcher.group(1);
            int number = Integer.parseInt(matcher.group(2));

            result.computeIfAbsent(region, r -> new HashMap<>())
                    .merge(number, 1, Integer::sum);
        }

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


}
