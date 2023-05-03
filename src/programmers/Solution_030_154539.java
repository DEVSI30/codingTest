package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_030_154539 {
    public int[] solution(int[] numbers) {
        int[] nextGreaterElement = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            nextGreaterElement[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.addFirst(numbers[i]);
        }

        return nextGreaterElement;
    }
}
