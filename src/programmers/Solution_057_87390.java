package programmers;
public class Solution_057_87390 {
    public int[] solution(int n, long left, long right) {
        long startX = left % n;
        long startY = left / n;
        int size = (int) (right - left + 1);

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            /**
             * 2차원 배열의 좌표를 x, y 라고 하면
             * max(x,y) 가 k 이면 k + 1
             */
            answer[i] = (int) Math.max(startX, startY) + 1;

            // 다음 좌표로 이동
            // (current 를 증가시키며 계속 % 와 / 연산을 하는 것보다 증가 연산 후 조건 확인이 더 빠름)
            startX++;
            if(startX == n){
                startX = 0;
                startY++;
            }
        }

        return answer;
    }
}
