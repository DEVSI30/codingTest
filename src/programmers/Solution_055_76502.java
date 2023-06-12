package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_055_76502 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotateString = s.substring(i, s.length()) + s.substring(0, i);
            if (isRightParentheses(rotateString)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isRightParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character last = stack.pollLast();
                if ((c == ')' && last != '(')
                        || (c == ')' && last != '(')
                        || (c == '}' && last != '{')) {
                    return false;
                }
            } else {
                stack.addLast(c);
            }
        }

        return stack.isEmpty();
    }
}
