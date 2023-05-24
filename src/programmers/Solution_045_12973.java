package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_045_12973 {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
