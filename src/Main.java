import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_081_68936 solution = new Solution_081_68936();
        int[] result = solution.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        System.out.println("result = " + result[0]);
        System.out.println("result = " + result[1]);
    }
}

