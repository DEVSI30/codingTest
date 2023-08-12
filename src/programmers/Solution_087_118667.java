package programmers;

import java.util.ArrayDeque;

public class Solution_087_118667 {
    private final int[] p1 = {0, 1};
    private final int[] p2 = {1, 0};

    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Status> statuses = new ArrayDeque<>();
        int lengthSum = queue1.length + queue2.length;
        boolean[][] visited = new boolean[lengthSum][lengthSum];
        int[] queueConcat = new int[lengthSum];
        System.arraycopy(queue1, 0, queueConcat, 0, queue1.length);
        System.arraycopy(queue2, 0, queueConcat, queue1.length, queue2.length);

        long q1Sum = getSum(queue1);
        long q2Sum = getSum(queue2);

        if (q1Sum == q2Sum) {
            return 0;
        }

        statuses.add(new Status(0, 0, q1Sum, q2Sum));

        while (!statuses.isEmpty()) {
            Status now = statuses.pollFirst();

            for (int i = 0; i < 2; i++) {
                int nextQ1Count = now.q1popCount + p1[i];
                int nextQ2Count = now.q2popCount + p2[i];
                int indexQ1 = (now.q1popCount) % queueConcat.length;
                int indexQ2 = (now.q2popCount + queue1.length) % queueConcat.length;
                int nextQ1Index = nextQ1Count;
                int nextQ2Index = nextQ2Count;

                if (nextQ1Index == queueConcat.length || nextQ2Index == queueConcat.length) {
                    continue;
                }

                if (visited[nextQ1Index][nextQ2Index]) {
                    continue;
                }
                int q1PopValue = queueConcat[indexQ1];
                int q2PopValue = queueConcat[indexQ2];
                long nextQ1Sum = now.q1Sum - p1[i] * q1PopValue + p2[i] * q2PopValue;
                long nextQ2Sum = now.q2Sum - p2[i] * q2PopValue + p1[i] * q1PopValue;

                if (nextQ1Sum == nextQ2Sum) {
                    return now.q1popCount + now.q2popCount + 1;
                }

                visited[nextQ1Index][nextQ2Index] = true;
                statuses.addLast(new Status(nextQ1Count, nextQ2Count, nextQ1Sum, nextQ2Sum));
            }
        }

        return -1;
    }

    public long getSum(int[] queue) {
        long result = 0;
        for (int i : queue) {
            result += i;
        }
        return result;
    }

    public class Status {
        private int q1popCount;
        private int q2popCount;

        private long q1Sum;
        private long q2Sum;

        public Status(int q1popCount, int q2popCount, long q1Sum, long q2Sum) {
            this.q1popCount = q1popCount;
            this.q2popCount = q2popCount;
            this.q1Sum = q1Sum;
            this.q2Sum = q2Sum;
        }
    }
}
