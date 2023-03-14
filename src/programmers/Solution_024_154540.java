package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_024_154540 {
    public int[] solution(String[] maps) {
        int MAP_X_SIZE = maps.length;
        int MAP_Y_SIZE = maps[0].length();

        int[][] map = new int[MAP_X_SIZE][MAP_Y_SIZE];

        int x_index;
        int y_index = 0;
        for (String row : maps) {
            x_index = 0;
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    map[y_index][x_index] = -1;
                } else {
                    map[y_index][x_index] = Integer.parseInt(c + "");
                }
                x_index++;
            }
            y_index++;
        }

        boolean[][] visited = new boolean[MAP_X_SIZE][MAP_Y_SIZE];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < MAP_Y_SIZE; i++) {
            for (int j = 0; j < MAP_X_SIZE; j++) {
                int visit_result = visit(map, visited, i, j);
                if (visit_result != 0) {
                    result.add(visit_result);
                }
            }
        }

        Collections.sort(result);

        int[] answer = new int[result.size()];

        if (result.size() == 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public int visit(int[][] map, boolean[][] visited, int x, int y) {
        int result = 0;

        // 범위가 넘었으면 0 을 return
        if (x < 0 || y < 0) {
            return 0;
        }

        if (map.length <= y) {
            return 0;
        }

        if (map[0].length <= x) {
            return 0;
        }

        // 이미 방문 했다면 0 을 return
        if (visited[y][x]) {
            return result;
        }

        visited[y][x] = true;
        if (map[y][x] == -1) {
            return result;
        }

        result += map[y][x];

        // 상하좌우
        result += visit(map, visited, x + 1, y);
        result += visit(map, visited, x - 1, y);
        result += visit(map, visited, x, y + 1);
        result += visit(map, visited, x, y - 1);

        return result;
    }
}
