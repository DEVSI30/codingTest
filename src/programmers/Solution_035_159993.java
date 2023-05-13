package programmers;

import java.util.ArrayDeque;

// Hint1 : 최단 거리 문제이니 BFS를 사용한다
// Hint2 : Start -> Lever -> End 를 거쳐야 한다.
// Hint3 : Start -> Lever 가는 거리와 Lever -> Start 까지 가는 거리가 동일하다
// Hint4 : Lever -> Start, Lever -> End 로 가는 거리를 한 번에 구한다
public class Solution_035_159993 {
    private Point startPoint;
    private Point leverPoint;
    private Point endPoint;
    private int height;
    private int width;
    private int[][] map;
    final int NOT_VISITED = -1;
    final int WALL = -2;

    private Point[] directions;

    public int solution(String[] maps) {
        initialize(maps);
        parse(maps);
        return solve();
    }

    public void initialize(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        map = new int[height][width];

        directions = new Point[]{
                new Point(1, 0),
                new Point(0, 1),
                new Point(-1, 0),
                new Point(0, -1)
        };
    }

    public void parse(String[] maps) {
        int y = 0;
        for (String row : maps) {
            int x = 0;
            for (char c : row.toCharArray()) {
                map[y][x] = NOT_VISITED;
                if (c == 'S') {
                    startPoint = new Point(x, y);
                } else if (c == 'E') {
                    endPoint = new Point(x, y);
                } else if (c == 'L') {
                    leverPoint = new Point(x, y);
                    map[y][x] = 0;
                } else if (c == 'X') {
                    map[y][x] = WALL;
                }
                x++;
            }
            y++;
        }
    }

    public int solve() {
        ArrayDeque<Point> pointQueue = new ArrayDeque<>();
        pointQueue.addLast(leverPoint);

        while(!pointQueue.isEmpty() && !startAndEndPointVisited()) {
            Point p = pointQueue.poll();

            for (Point d : directions) {
                Point np = new Point(p.x + d.x, p.y + d.y);
                // 다음 포인트가 범위를 초과했거나 벽이라면 continue 한다
                if(outOfRange(np)) continue;
                int mapValue = map[np.y][np.x];
                if(mapValue == WALL) continue;

                // 방문하지 않았다면 큐에 넣는다
                if(mapValue == NOT_VISITED) {
                    pointQueue.addLast(np);
                }

                int newValue = map[p.y][p.x] + 1;
                if(mapValue == NOT_VISITED || mapValue > newValue) {
                    map[np.y][np.x] = newValue;
                }
            }
        }

        if(map[startPoint.y][startPoint.x] == NOT_VISITED || map[endPoint.y][endPoint.x] == NOT_VISITED){
            return -1;
        }

        return map[startPoint.y][startPoint.x] + map[endPoint.y][endPoint.x];
    }

    public boolean startAndEndPointVisited() {
        if(map[startPoint.y][startPoint.x] != NOT_VISITED && map[endPoint.y][endPoint.x] != NOT_VISITED) {
            return true;
        }
        return false;
    }

    public boolean outOfRange(Point p){
        if(p.x < 0 || p.x >=  width || p.y < 0 || p.y >= height){
            return true;
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
