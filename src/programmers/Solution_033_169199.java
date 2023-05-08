package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_033_169199 {
    private int height;
    private int width;
    private boolean[][] map;
    private boolean[][] visited;
    private Position startPoint;

    private Position endPoint;

    // 탐색에 최소 방문 횟수를 구하는 문제니 BFS
    public int solution(String[] board) {
        initialize(board);
        parse(board);
        return solve();
    }

    public void initialize(String[] board) {
        height = board.length;
        width = board[0].length();
        map = new boolean[height][width];
        visited = new boolean[height][width];
        startPoint = new Position();
        endPoint = new Position();
    }

    public void parse(String[] board) {
        int y = 0;
        for (String row : board) {
            int x = 0;
            for (char c : row.toCharArray()) {
                if (c == 'R') {
                    startPoint.setPosition(x, y);
                } else if (c == 'G') {
                    endPoint.setPosition(x, y);
                } else if (c == 'D') {
                    map[y][x] = true;
                }
                x++;
            }
            y++;
        }
    }

    public int solve() {
        Deque<Position> positionDeque = new ArrayDeque<>();
        positionDeque.addLast(startPoint);

        Direction[] directions = new Direction[]{Direction.L, Direction.R, Direction.D, Direction.U};

        while (!positionDeque.isEmpty()) {
            Position position = positionDeque.poll();
            visited[position.y][position.x] = true;

            for (Direction direction : directions) {
                Position nextPosition = getNextPos(position, direction);
                if (nextPosition.y == endPoint.y && nextPosition.x == endPoint.x) {
                    return nextPosition.count;
                }

                // 방문 했다면 Queue 에 넣지 않는다
                if (!visited[nextPosition.y][nextPosition.x]) {
                    positionDeque.addLast(nextPosition);
                }
            }
        }

        return -1;
    }

    public Position getNextPos(Position now, Direction direction) {
        int x = now.x;
        int y = now.y;
        switch (direction) {
            case L:
                for (int i = x - 1; i >= 0; i--) {
                    if (map[y][i]) return new Position(i + 1, y, now.count + 1);
                }
                return new Position(0, y, now.count + 1);
            case R:
                for (int i = x + 1; i < width; i++) {
                    if (map[y][i]) return new Position(i - 1, y, now.count + 1);
                }
                return new Position(width - 1, y, now.count + 1);
            case D:
                for (int i = y - 1; i >= 0; i--) {
                    if (map[i][x]) return new Position(x, i + 1, now.count + 1);
                }
                return new Position(x, 0, now.count + 1);
            case U:
                for (int i = y + 1; i < height; i++) {
                    if (map[i][x]) return new Position(x, i - 1, now.count + 1);
                }
                return new Position(x, height - 1, now.count + 1);
        }
        return new Position();
    }

    static class Position {
        int x;
        int y;
        int count;

        public Position() {
            count = 0;
        }

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    enum Direction {
        L, R, U, D

    }
}
