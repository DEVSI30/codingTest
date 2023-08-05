package programmers;

import java.util.Stack;

public class Solution_083_42883 {
    public String solution(String number, int k) {
        // ABCDEFGH... 일 때 A < B 이면 A를 빼는게 가장 큰 영향력을 가진다.
        // 국소적인 문제에서 최선의 해결책이 전체에서의 최선의 해결책이 되는 문제는 그리드 알고리즘으로 해결할 수 있다.
        Stack<Integer> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            int now = Integer.parseInt(String.valueOf(c));
            while (k > 0 && !stack.isEmpty() && stack.peek() < now) {
                stack.pop();
                k--;
            }
            stack.push(now);
        }

        // k 가 남아있을 수 있다.
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        for (Integer s : stack) {
            result.append(s);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
