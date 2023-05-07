import programmers.Solution_031_176962;
import programmers.Solution_032_172927;

public class Main {
    public static void main(String[] args) {
        Solution_032_172927 solution031176962 = new Solution_032_172927();
        int minimumCost = solution031176962.solution(new int[]{1, 1, 0}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"});
        System.out.println("minimumCost = " + minimumCost);
    }


}

