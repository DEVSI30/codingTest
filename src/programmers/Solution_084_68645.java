package programmers;

public class Solution_084_68645 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x <= y; x++) {
                int group = 0;
                int od = Math.min(x, y - x);
                while (od != group && y != n - 1 - group) {
                    group++;
                }
                int nowX = x - group;
                int nowY = y - group * 2;
                int nowN = n - 3 * group;
                int offset = (group + 1) * group / 2 * -9 + (3 * n + 6) * group + 1;
                answer[index++] = (nowY == nowN - 1 || nowX == 0) ? nowY + nowX + offset : 3 * (nowN - 1) - nowY + offset;
            }
        }
        return answer;
    }
}
