package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_059_64065 {
    public int[] solution(String s) {
        String[] splited = s.trim().replaceAll("\\{", "").replaceAll("\\}", "").split(",");

        Map<Integer, Integer> countMap = new HashMap<>();

        for (String numberString : splited) {
            int number = Integer.parseInt(numberString);

            countMap.putIfAbsent(number, 0);
            countMap.put(number, countMap.get(number) + 1);
        }

        return countMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).map(x -> x.getKey()).mapToInt(x -> x).toArray();
    }
}
