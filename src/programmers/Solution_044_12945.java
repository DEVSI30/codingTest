package programmers;
public class Solution_044_12945 {
    public static final int MODULUS = 1234567;

    public int solution(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b % MODULUS;
            b = c % MODULUS;
        }
        return (c % MODULUS);
    }
}
