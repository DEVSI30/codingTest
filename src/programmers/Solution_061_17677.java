package programmers;

import java.util.*;

public class Solution_061_17677 {
    private final int MULTIPLY = 65536;

    public int solution(String str1, String str2) {
        Map<String, Integer> c1 = getCountMap(getStringToList(str1));
        Map<String, Integer> c2 = getCountMap(getStringToList(str2));

        Map<String, Integer> intersection = getIntersection(c1, c2);
        Map<String, Integer> union = getUnion(c1, c2);

        return getJaccardSimilarity(getCountMapSize(intersection), getCountMapSize(union));
    }

    public List<String> getStringToList(String s) {
        List<String> result = new ArrayList<>();

        s = s.toUpperCase();
        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isAlphabetic(s.charAt(i)) && Character.isAlphabetic(s.charAt(i + 1))) {
                result.add(s.substring(i, i + 2));
            }
        }

        return result;
    }

    public Map<String, Integer> getCountMap(List<String> strings) {
        Map<String, Integer> result = new HashMap<>();

        for (String s : strings) {
            result.putIfAbsent(s, 0);
            result.put(s, result.get(s) + 1);
        }

        return result;
    }

    public Map<String, Integer> getIntersection(Map<String, Integer> m1, Map<String, Integer> m2) {
        Set<String> intersectionKeys = new HashSet<>();
        intersectionKeys.addAll(m1.keySet());
        intersectionKeys.retainAll(m2.keySet());

        Map<String, Integer> result = new HashMap<>();

        for (String key : intersectionKeys) {
            result.put(key, Math.min(m1.get(key), m2.get(key)));
        }
        return result;
    }

    public Map<String, Integer> getUnion(Map<String, Integer> m1, Map<String, Integer> m2) {
        Set<String> unionKeys = new HashSet<>();
        unionKeys.addAll(m1.keySet());
        unionKeys.addAll(m2.keySet());

        Map<String, Integer> result = new HashMap<>();

        for (String key : unionKeys) {
            int sum = Math.max(m1.getOrDefault(key, 0), m2.getOrDefault(key, 0));
            result.put(key, sum);
        }
        return result;
    }

    public int getCountMapSize(Map<String, Integer> map) {
        int size = 0;
        for (String key : map.keySet()) {
            size += map.get(key);
        }
        return size;
    }

    public int getJaccardSimilarity(int intersectionSize, int unionSize) {
        if (unionSize == 0) {
            return MULTIPLY;
        }
        return (int) Math.floor(((double) intersectionSize / (double) unionSize) * MULTIPLY);
    }
}
