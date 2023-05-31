package programmers;

public class Solution_050_12953 {
    public int solution(int[] arr) {
        int answer = 0;

        while (true) {
            answer += 1;
            boolean leastCommonMultiple = true;

            for (int i : arr) {
                if (answer % i != 0) {
                    leastCommonMultiple = false;
                    break;
                }
            }

            if (leastCommonMultiple) {
                break;
            }
        }
        return answer;
    }
}
