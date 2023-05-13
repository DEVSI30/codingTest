import programmers.Solution_031_176962;
import programmers.Solution_032_172927;
import programmers.Solution_033_169199;
import programmers.Solution_034_169198;

public class Main {
    public static void main(String[] args) {
        Solution_034_169198 solution031176962 = new Solution_034_169198();
        int[] solution = solution031176962.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }


}

