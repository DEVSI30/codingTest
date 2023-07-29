package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class Solution_076_132265 {
    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int t : topping) {
            Integer count = hashMap.getOrDefault(t, 0);
            hashMap.put(t, count + 1);
        }

        HashSet<Integer> left = new HashSet<>();

        for (int t : topping) {
            left.add(t);
            hashMap.put(t, hashMap.get(t) - 1);
            if (hashMap.get(t) == 0) {
                hashMap.remove(t);
            }

            if (left.size() == hashMap.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}
