package programmers;

public class Solution_074_17679 {
    private final Character EMPTY = '0';
    private int HEIGHT;
    private int WIDTH;

    // m : height, n: width
    public int solution(int m, int n, String[] board) {
        HEIGHT = m;
        WIDTH = n;
        Character[][] board2D = new Character[HEIGHT][WIDTH];
        boolean[][] removeNext = new boolean[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            String now = board[y];
            for (int x = 0; x < WIDTH; x++) {
                board2D[y][x] = now.charAt(x);
            }
        }

        int removeCountTotal = 0;
        int removeCount = 1;

        while (removeCount > 0) {
            // 초기화 하기
            removeCount = 0;
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    removeNext[y][x] = false;
                }
            }

            // 몇 개 지워지는지 세기
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    removeCount += check4(board2D, removeNext, x, y);
                }
            }

            // 지우기
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    if (removeNext[y][x]) {
                        board2D[y][x] = EMPTY;
                    }
                }
            }

            // 땡기기
            for (int x = 0; x < WIDTH; x++) {
                for (int t = 0; t < HEIGHT - 1; t++) {
                    for (int y = HEIGHT - 1; y > 0; y--) {
                        if(board2D[y][x] == EMPTY){
                            board2D[y][x] = board2D[y-1][x];
                            board2D[y-1][x] = EMPTY;
                        }
                    }
                }
            }

            removeCountTotal += removeCount;
        }
        return removeCountTotal;
    }

    int check4(Character[][] board2D, boolean[][] removeNext, int x, int y) {
        if (x + 1 >= WIDTH || y + 1 >= HEIGHT) {
            return 0;
        }

        Character now = board2D[y][x];
        if (now == EMPTY) {
            return 0;
        }

        if (now == board2D[y][x + 1] &&
                now == board2D[y + 1][x] &&
                now == board2D[y][x + 1] &&
                now == board2D[y + 1][x + 1]) {
            int alreadyRemoved = (removeNext[y][x] ? 1 : 0) + (removeNext[y][x + 1] ? 1 : 0) + (removeNext[y + 1][x] ? 1 : 0) + (removeNext[y + 1][x + 1] ? 1 : 0);

            removeNext[y][x] = true;
            removeNext[y][x + 1] = true;
            removeNext[y + 1][x] = true;
            removeNext[y + 1][x + 1] = true;

            return 4 - alreadyRemoved;
        }

        return 0;
    }
}
