package programmers;

import java.util.Arrays;

public class Solution_054_42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = 0;
        int index = citations.length - 1;

        for (int h = citations[index]; h > 0; h--) {
            while (index >= 0 && citations[index] >= h) {
                n++;
                index--;
            }

            if (n >= h) {
                return h;
            }
        }
        return 0;
    }
}
