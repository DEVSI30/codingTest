package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Solution_021_86491 {
    public int solution(int[][] sizes) {
        /*
        힌트1. 리스트에서 최대값은 가로던지 세로던지 무조건 들어가야 한다.
        가로x세로 중 작은 값에서 max 값을 구하면 답이다.
         */
        int maxValue = 0;
        int maxOfMin = 0;

        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            int maxNow = Math.max(width, height);
            int minNow = Math.min(width, height);

            if (maxNow > maxValue) maxValue = maxNow;
            if (minNow > maxOfMin) maxOfMin = minNow;
        }

        return maxValue * maxOfMin;
    }
}
