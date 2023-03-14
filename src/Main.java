import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_024_154540 solution = new Solution_024_154540();
        int[] answers = solution.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}
