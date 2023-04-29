package programmers;

public class Solution_029_181187 {
    public long solution(int r1, int r2) {
        long sum = 0;
        for (int x = 1; x <= r2; x++) {
            double yMax = Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            double yMin = 0;
            if(x < r1) {
                yMin = Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            }

            sum += (int)(yMax) - (int)(yMin) + 1;
        }

        return sum * 4;
    }
}
