package programmers;

public class Solution_051_12914 {
    private final long MODULOR = 1234567L;

    // 피보나치 수임
    public long solution(int n) {
        if (n <= 2) {
            return n;
        }

        long prev1 = 1L;
        long perv2 = 2L;
        long current = 0L;

        for (int i = 3; i <= n; i++) {
            current = (prev1 + perv2) % MODULOR;
            prev1 = perv2;
            perv2 = current;
        }

        return current;
    }
}
