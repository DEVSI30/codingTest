package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_028_181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int last_end = -1;
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            if(start >= last_end) {
                last_end = end;
                count++;
            }
            else if(end < last_end) {
                last_end = end;
            }
        }
        return count;
    }
}
