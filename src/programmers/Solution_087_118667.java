package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_087_118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int totalLength = queue1.length + queue2.length;
        ArrayDeque<Integer> q1 = new ArrayDeque<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        ArrayDeque<Integer> q2 = new ArrayDeque<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));

        long q1Sum = getSum(queue1);
        long q2Sum = getSum(queue2);
        long totalSum = q1Sum + q2Sum;

        // 두 큐의 합이 같다면 바로 종료
        if (q1Sum == q2Sum) {
            return 0;
        }

        // 두 큐의 합이 같다는 건 각각 합이 N, N 이 되어야 같아지는데 그 합은 2N, 즉 짝수이다.
        if (totalSum % 2 == 1) {
            return -1;
        }

        while (q1Sum != q2Sum) {
            // 큰 쪽에서 작은 쪽으로 이동
            if (q1Sum > q2Sum) {
                Integer polled = q1.pollFirst();
                q2.addLast(polled);
                q1Sum -= polled;
                q2Sum += polled;
            } else if (q1Sum < q2Sum) {
                Integer polled = q2.pollFirst();
                q1.addLast(polled);
                q1Sum += polled;
                q2Sum -= polled;
            }
            answer++;
            if (answer == 2 * totalLength) {
                return -1;
            }
        }
        return answer;
    }

    public long getSum(int[] queue) {
        long result = 0;
        for (int i : queue) {
            result += i;
        }
        return result;
    }
}
