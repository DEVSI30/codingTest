package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_037_152996 {
    private Map<Integer, Long> countMap = new HashMap<>();

    public long solution(int[] weights) {
        countMap = Arrays.stream(weights).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        long sum = countMap.values().stream().map(x -> x * (x - 1) / 2).reduce(Long::sum).get(); // 1 : 1 인 비율인 짝
        // 2:3, 2:4, 3:4

        for (int i = 2; i < 4; i++) {
            for (int j = i + 1; j <= 4; j++) {
                for (Integer key : countMap.keySet()) {
                    if ((key * j) % i != 0) continue;
                    Integer newKey = (key * j) / i;
                    if (countMap.containsKey(newKey)) {
                        sum += countMap.get(key) * countMap.get(newKey);
                    }
                }
            }
        }
        return sum;
    }
}
