package programmers;

public class Solution_058_12949 {
    public int[][] solution(int[][] A, int[][] B) {
        int heightA = A.length;
        int widthB = B[0].length;

        int[][] answer = new int[heightA][widthB];

        for (int i = 0; i < heightA; i++) {
            for (int j = 0; j < widthB; j++) {
                int sum = 0;
                for (int k = 0; k < B.length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
