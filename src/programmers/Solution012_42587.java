package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution012_42587 {
    // 코딩 테스트에서는 클래스 만들면 안되나요?
    static class Node {
        private final int priority;
        private final int position;

        public Node(int priority, int position) {
            this.priority = priority;
            this.position = position;
        }

        public int getPriority() {
            return priority;
        }

        public int getPosition() {
            return position;
        }
    }
    public int solution(int[] priorities, int location) {

        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int position = 0; position < priorities.length; position++) {
            priorityQueue.add(priorities[position]);
            queue.add(new Node(priorities[position], position));
        }

        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            Integer maxPriority = priorityQueue.poll();
            while (!queue.isEmpty()) {
                Node firstNode = queue.poll();
                if (firstNode.getPriority() == maxPriority) {
                    answer++;
                    if (firstNode.getPosition() == location) {
                        return answer;
                    }
                    break;
                }
                queue.add(firstNode);
            }
        }
        return answer;
    }
}
