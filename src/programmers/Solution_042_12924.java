package programmers;

public class Solution_042_12924 {
    public int solution(int n) {
        // n 이 1 일 때는 무조건 존재
        int answer = 1;

        for (int i = 2; i <= n; i++) {
            // 연속된 합으로 표현 가능하면 answer 증가
            if (checkConsecutiveSum(n, i)) {
                answer++;
            }

            // 1부터 i 까지의 값(연속된 자연수의 최소 값) 이 n 보다 크면 break
            if ((i * (i - 1)) / 2 > n) {
                break;
            }
        }
        return answer;
    }

    private boolean checkConsecutiveSum(int target, int times) {
        int numerator = target * 2 - times * times + times;
        int denominator = 2 * times;
        if (numerator <= 0) return false;
        return (numerator % denominator) == 0;
    }
}
