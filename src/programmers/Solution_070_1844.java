package programmers;

import java.util.ArrayDeque;

public class Solution_070_1844 {
    private final int WALL = 0;
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    // 최단거리 == BFS
    // BFS = Queue, Status, Visited
    // 종료 조건: 오른쪽 하단에 도착
    // 출발 위치: 0, 0
    public int solution(int[][] maps) {
        int HEIGHT = maps.length;
        int WIDTH = maps[0].length;
        boolean[][] visitied = new boolean[HEIGHT][WIDTH];

        ArrayDeque<Status> queue = new ArrayDeque<>();
        queue.add(new Status(0, 0, 1));

        while (queue.isEmpty() == false) {
            Status nowStatus = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = nowStatus.x + dx[i];
                int ny = nowStatus.y + dy[i];

                // 범위 확인
                if (nx < 0 || nx > WIDTH - 1 || ny < 0 || ny > HEIGHT - 1) {
                    continue;
                }

                // 벽 확인
                if (maps[ny][nx] == WALL) {
                    continue;
                }

                // 방문 확인
                if (visitied[ny][nx]) {
                    continue;
                }

                // 종료 조건
                if (nx == WIDTH - 1 && ny == HEIGHT - 1) {
                    return nowStatus.count + 1;
                }

                queue.addLast(new Status(nx, ny, nowStatus.count + 1));
                visitied[ny][nx] = true;
            }
        }

        return -1;
    }

    public class Status {
        private int x;
        private int y;
        private int count;

        public Status(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
