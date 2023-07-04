import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_067_92341 solution = new Solution_067_92341();
        int[] result = solution.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
        for (int s : result) {
            System.out.println("s = " + s);
        }
    }
}

