package programmers;

import java.util.*;

public class Solution_060_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();
        Queue<String> discountHistory = new ArrayDeque<>();
        for (String d : discount) {
            discountMap.putIfAbsent(d, 0);
            discountMap.put(d, discountMap.get(d) + 1);

            discountHistory.add(d);
            if (discountHistory.size() == 11) {
                String poll = discountHistory.poll();
                discountMap.put(poll, discountMap.get(poll) - 1);
            }

            if (matchMap(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean matchMap(Map<String, Integer> m1, Map<String, Integer> m2) {
        // m1 이 기준
        for (String k1 : m1.keySet()) {
            if (!m2.containsKey(k1)) {
                return false;
            }
            if (!Objects.equals(m1.get(k1), m2.get(k1))) {
                return false;
            }
        }
        return true;
    }
}
