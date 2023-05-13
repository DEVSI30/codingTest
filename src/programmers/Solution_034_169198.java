package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_034_169198 {
    // 대칭이동으로 풀어야 한다는 답을 봐버렸다..
    private int mapWidth;
    private int mapHeight;
    private Point startPoint;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        mapWidth = m;
        mapHeight = n;
        startPoint = new Point(startX, startY);

        for (int i = 0; i < balls.length; i++) {
            answer[i] = getShortestValidPath(new Point(balls[i][0], balls[i][1]));
        }

        return answer;
    }

    public int getShortestValidPath(Point targetPoint) {
        List<Point> mirroredPoints = getMirroredPoints(targetPoint);
        return mirroredPoints.stream().map(p -> getDistanceSquare(startPoint, p)).min(Integer::compareTo).get();
    }

    private List<Point> getMirroredPoints(Point targetPoint) {
        List<Point> validPoints = new ArrayList<>();
        int x = targetPoint.x;
        int y = targetPoint.y;
        if (startPoint.y != y || startPoint.x >= x) {
            validPoints.add(new Point(2 * mapWidth - x, y));
        }
        if (startPoint.y != y || startPoint.x <= x) {
            validPoints.add(new Point(-x, y));
        }
        if (startPoint.x != x || startPoint.y >= y) {
            validPoints.add(new Point(x, 2 * mapHeight - y));
        }
        if (startPoint.x != x || startPoint.y <= y ) {
            validPoints.add(new Point(x, -y));
        }
        return validPoints;
    }

    public int getDistanceSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
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
