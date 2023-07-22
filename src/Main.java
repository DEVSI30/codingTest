import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_073_17686 solution = new Solution_073_17686();
        String[] result = solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }
}

