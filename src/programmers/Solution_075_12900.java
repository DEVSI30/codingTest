package programmers;

public class Solution_075_12900 {
    private final int MOD_NUM = 1000000007;

    public int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % MOD_NUM;
        }

        return array[n];
    }
}
