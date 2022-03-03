package programmers;

import java.util.PriorityQueue;

public class Solution004_42626_useLibrary {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int s : scoville) {
            minHeap.add(s);
        }

        int leftHand = -1;
        while (!minHeap.isEmpty()) {
            int minimumScovile = minHeap.poll();
            if (minimumScovile >= K && leftHand == -1) {
                return answer;
            }

            if (leftHand == -1) {
                leftHand = minimumScovile;
            } else {
                int newScovile = leftHand + minimumScovile * 2;
                minHeap.add(newScovile);
                answer++;
                leftHand = -1;
            }

        }
        return -1;
    }
}
