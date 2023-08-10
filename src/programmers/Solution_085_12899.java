package programmers;
public class Solution_085_12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int mod = n % 3;
            if (mod == 0) {
                sb.append("4");
                n -= 1;
            } else if (mod == 1) {
                sb.append("1");
            }
            else {
                sb.append("2");
            }

            n /= 3;
        }

        return sb.reverse().toString();
    }
}
