package programmers;

import java.util.*;

public class Solution_020_427878 {
    public int[] solution(String msg) {
        Map<String, Integer> LZW = new HashMap<>();
        String AtoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < AtoZ.length(); i++) {
            LZW.put(AtoZ.charAt(i) + "", i+1);
        }
        List<Integer> answer = new ArrayList<>();

        int si = 0;
        while (true) {
            int size = 1;
            String last = msg.substring(si, si + size);
            String next = msg.substring(si, si + size);
            while (si + size < msg.length() && LZW.containsKey(next)) {
                last = next;
                size++;
                next = msg.substring(si, si + size);
            }
            if (!LZW.containsKey(next)) {
                LZW.put(next, LZW.size()+1);
                answer.add(LZW.get(last));
                si += last.length();
            }
            else {
                answer.add(LZW.get(next));
                si += next.length();
            }

            if (si >= msg.length()) break;
        }

        int[] answerInt = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerInt[i] = answer.get(i);
        }
        return answerInt;
    }
}
