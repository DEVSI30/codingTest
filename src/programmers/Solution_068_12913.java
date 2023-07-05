package programmers;

import java.util.Arrays;

public class Solution_068_12913 {
    // 위에서 최선의 값을 선택하려고 하면
    // 아래에 영향을 주기 때문에 일이 점점 복잡해진다.
    // 제일 밑에서부터 시작하면 영향을 줄 대상이 없어져서 문제가 단순해진다
    public int solution(int[][] land) {
        int height = land.length;
        int width = land[0].length;
        int[] maxP = new int[]{};

        for (int j = 0; j < width; j++) {
            maxP[j] = land[height - 1][j];
        }

        for (int i = height - 2; i >= 0; i--) {
            int[] nextMaxP = new int[width];
            for (int j = 0; j < width; j++) {
                nextMaxP[j] = land[i][j] + getMax(maxP, j);
            }
            for (int j = 0; j < width; j++) {
                maxP[j] = nextMaxP[j];
            }
        }

        return Arrays.stream(maxP).max().getAsInt();
    }

    public int getMax(int[] values, int exceptIndex) {
        int max = -1;
        for (int i = 0; i < values.length; i++) {
            if (i == exceptIndex) continue;
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
