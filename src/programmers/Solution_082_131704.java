package programmers;

import java.util.Stack;

public class Solution_082_131704 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int k = 1;
        int answer = 0;

        // 기준은 order
        while (i < order.length) {
            if (order[i] == k) {
                answer++;
                i++;
                k++;
            } else if (!stack.isEmpty() && order[i] == stack.peek()) {
                stack.pop();
                i++;
                answer++;
            } else {
                // 컨테이너 벨트가 끝났으면 종료
                if (k == order.length) {
                    break;
                }
                stack.push(k);
                k++;
            }
        }

        return answer;
    }
}
