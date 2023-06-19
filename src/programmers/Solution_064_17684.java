package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution_064_17684 {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new TreeMap<>();
        int maxValue = 0;
        int A = 65;
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf(((char) (A + i))), ++maxValue);
        }
        List<Integer> answer = new ArrayList<>();

        int index = 0;
        while (index < msg.length()) {
            // 남은게 한 글자라면 answer 에 넣고 끝
            if (index == msg.length() - 1) {
                answer.add(dict.get(String.valueOf(msg.charAt(index))));
                break;
            }
            StringBuilder largestWord = new StringBuilder();

            do {
                largestWord.append(msg.charAt(index));
                index++;
            }
            while (dict.containsKey(largestWord.toString()) && index < msg.length());

            if (!dict.containsKey(largestWord.toString())) {
                dict.put(largestWord.toString(), ++maxValue);
                answer.add(dict.get(largestWord.toString().substring(0, largestWord.length() - 1)));
                index--;
            } else {
                answer.add(dict.get(largestWord.toString()));
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
