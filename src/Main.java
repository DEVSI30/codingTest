import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_064_17684 solution = new Solution_064_17684();
        int[] kakaos = solution.solution("TOBEORNOTTOBEORTOBEORNOT");
        for (int kakao : kakaos) {
            System.out.println("kakao = " + kakao);
        }
    }
}

