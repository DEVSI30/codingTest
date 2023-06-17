import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_059_64065 solution = new Solution_059_64065();
        int[] solution1 = solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        for (int i : solution1) {
            System.out.println("i = " + i);
        }
    }
}

