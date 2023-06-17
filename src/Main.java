import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_060_131127 solution = new Solution_060_131127();
        int solution1 = solution.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println("solution1 = " + solution1);
    }
}

