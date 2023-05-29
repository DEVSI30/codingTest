package programmers;

public class Solution_047_12985 {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a % 2 == 1) ? (a + 1) / 2 : a / 2;
            b = (b % 2 == 1) ? (b + 1) / 2 : b / 2;
            answer++;
        }

        return answer;
    }
}
