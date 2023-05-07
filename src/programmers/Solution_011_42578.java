package programmers;

import java.util.HashMap;

public class Solution_011_42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];

            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (String key : clothesMap.keySet()) {
            answer *= (clothesMap.get(key) + 1);
        }

        return answer-1;
    }
}
