package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_030_154539 {
    public int[] solution(int[] numbers) {
        int[] answers = new int[numbers.length];

        Deque<Integer> deque = new ArrayDeque<>();

        // 뒤에서 찾는게 더 빠르다 (맨 처음부터 보면 모든 배열을 다 조회해야 할 수도 있다)
        for (int i = numbers.length - 1; i >= 0; i--) {
            int target = numbers[i];

            while (!deque.isEmpty()) {
                Integer peeked = deque.peek();
                // 스택에 제일 위에 있는 값이 현재 값보다 크면
                if (peeked > target) {
                    // 현재 값을 스택에 넣어주고
                    deque.push(target);
                    // 정답에 가장 가까이 있는(자신보다 뒤에있는) 값을 넣어준다
                    answers[i] = peeked;
                    // 정답을 찾았으므로 break
                    break;
                }
                // 스택에 가장 위에 있는 값이 현재 값보다 작다면 버린다
                deque.pop();
                // 현재 값보다 작다는건 현재의 왼쪽에 있는 값이 자신보다 더 큰 수를 찾을 때
                // 버리게 되는 값보다 작다면 현재의 값에서 더 큰 값을 먼저 찾게 될 것이기 때문이다
            }
            // deque 이 비어있다는건 target 보다 더 큰 값을 못 찾았다는 것이므로
            if (deque.isEmpty()) {
                answers[i] = -1; // -1 로 채워주고
                deque.push(target); // 현재 값을 deque 에 넣어준다
            }
        }
        return answers;
    }
}
