package programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution_052_17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> cacheSet = new HashSet<>();
        LinkedList<String> cacheList = new LinkedList<>();

        for (String city : cities) {
            String upperCity = city.toUpperCase();
            if (cacheSet.contains(upperCity)) {
                cacheList.remove(upperCity);
                cacheList.add(upperCity);
                answer++;
            } else {
                cacheSet.add(upperCity);
                cacheList.add(upperCity);
                if (cacheList.size() > cacheSize) {
                    String removedCity = cacheList.removeFirst();
                    cacheSet.remove(removedCity);
                }
                answer += 5;
            }
        }
        return answer;
    }
}
