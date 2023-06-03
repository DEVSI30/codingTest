package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_053_138476 {
    public int solution(int k, int[] tangerine) {
        List<Long> frequencyListOrderByDesc = Arrays
                .stream(tangerine)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .values()
                .stream()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int answer = 0;
        for (Long f : frequencyListOrderByDesc) {
            k -= f;
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
