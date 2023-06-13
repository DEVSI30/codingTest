package programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution_056_131701 {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int length = elements.length;
        int startSum = 0;
        for (int i = 1; i <= length; i++) {
            startSum += elements[i - 1];
            int sum = startSum;
            int start = 0;
            int end = i;
            sumSet.add(sum);
            for (int j = 0; j <= length; j++) {
                sum += elements[end % length];
                sum -= elements[start % length];
                sumSet.add(sum);
                start++;
                end++;
            }
        }

        return sumSet.size();
    }
}
