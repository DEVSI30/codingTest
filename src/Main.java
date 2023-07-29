import programmers.*;

public class Main {
    public static void main(String[] args) {
        Solution_077_77885 solution = new Solution_077_77885();
        long[] result = solution.solution(new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        long count = 1;
        for (long l : result) {
            System.out.println(count + " = " + l);
            count++;
        }
    }
}

