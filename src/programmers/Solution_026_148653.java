package programmers;

public class Solution_026_148653 {
    public int solution(int storey) {
        int numberOfDigit = Integer.toString(storey).length();
        int[] valueList = new int[numberOfDigit + 1];

        int remain = storey;

        for (int i = 0; i < numberOfDigit; i++) {
            valueList[i] =remain % 10;
            remain /= 10;
        }

        int[] strategies = new int[valueList.length];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < Math.pow(2, valueList.length); i++) {
            int sum = 0;
            int prev_up = 0;
            for (int j = 0; j < valueList.length; j++) {
                int value = valueList[j] + prev_up;
                int strategy = strategies[j];
                if(strategy == 0) {
                    sum += value;
                    prev_up = 0;
                }
                else {
                    sum += (10 - value);
                    prev_up = 1;
                }
            }

            if(sum < answer) {
                answer = sum;
            }

            // strategies 변경
            for (int j = 0; j < strategies.length - 1; j++) {
                if(j == 0){
                    strategies[j]++;
                }
                if(strategies[j] == 2) {
                    strategies[j] = 0;
                    strategies[j+1]++;
                }

            }

        }
        return answer;
    }

    // 10 자리면 경우의 수가 1024 라서 brute-force 로 풀 수 있을듯
}
