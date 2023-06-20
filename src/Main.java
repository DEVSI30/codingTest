import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_066_42888 solution = new Solution_066_42888();
        String[] result = solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }
}

