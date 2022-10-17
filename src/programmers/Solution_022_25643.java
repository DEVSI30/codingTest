package programmers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_022_25643 {
    public static boolean compare(String s1, String s2) {
        for (int i = 1; i < s1.length()+1; i++) {
            if (s1.substring(0, i).equals(s2.substring(s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public static int soultion(List<String> strings) {
        for (int i = 0; i < strings.size()-1; i++) {
            String bottom = strings.get(i);
            String top = strings.get(i + 1);

            if (!compare(bottom, top) && !compare(top, bottom)) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            strings.add(sc.nextLine());
        }

        sc.close();

        System.out.println(soultion(strings));
    }
}
