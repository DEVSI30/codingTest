package programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution_069_49994 {
    private final int SIZE = 5;

    // 좌표를 문자열로 만든 "0,0,0,0" 를 키로 해서 중복 체크
    //x랑 y 를 작은 값이 앞으로 가게 해서 방향성 제거
    public int solution(String dirs) {
        Set<String> pathSet = new HashSet<>();

        Position prevPosition = new Position(0, 0);

        for (char arrow : dirs.toCharArray()) {
            Position nextPosition = (new Position(prevPosition)).move(arrow);
            if (!prevPosition.compare(nextPosition)) {
                pathSet.add(generatePath(prevPosition, nextPosition));
            }
            prevPosition = nextPosition;
        }

        return pathSet.size();
    }

    public class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(Position o) {
            this.x = o.x;
            this.y = o.y;
        }

        public Position move(char arrow) {
            switch (arrow) {
                case 'D' -> {
                    if (this.y > -SIZE) {
                        this.y -= 1;
                    }
                    return this;
                }
                case 'U' -> {
                    if (this.y < SIZE) {
                        this.y += 1;
                    }
                    return this;
                }
                case 'L' -> {
                    if (this.x > -SIZE) {
                        this.x -= 1;
                    }
                    return this;
                }
                case 'R' -> {
                    if (this.x < SIZE) {
                        this.x += 1;
                    }
                    return this;
                }
            }
            return this;
        }

        public boolean compare(Position other) {
            return this.x == other.x && this.y == other.y;
        }
    }

    public String generatePath(Position a, Position b) {
        String[] positions = {
                String.valueOf(Math.min(a.x, b.x)),
                String.valueOf(Math.min(a.y, b.y)),
                String.valueOf(Math.max(a.x, b.x)),
                String.valueOf(Math.max(a.y, b.y)),
        };
        return String.join(",", positions);
    }
}
