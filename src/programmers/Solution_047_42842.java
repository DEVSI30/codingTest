package programmers;

public class Solution_047_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int total = brown + yellow;
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
        for (int height = 2; height <= total / 2; height++) {
            if (total % height != 0) continue;

            int width = total / height;
            int perimeter = (width + height) * 2 - 4;

            if (perimeter == brown) {
                answer[0] = width;
                answer[1] = height;
            }
        }
        return answer;
    }
}
