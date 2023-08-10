package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_086_133499 {
    public int solution(String[] babbling) {
        Set<String> possibleBabblingSet = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));
        int answer = 0;

        for (String b : babbling) {
            int index = 0;
            // 동일한 단어는 두 번 연속 말하지 못한다
            String lastWord = "";
            boolean possible = true;

            while (index < b.length()) {
                boolean startsWithValidWord = false;
                for (String p : possibleBabblingSet) {
                    if (b.startsWith(p, index) && !lastWord.equals(p)) {
                        startsWithValidWord = true;
                        index += p.length();
                        lastWord = p;
                        break;
                    }
                }
                if (!startsWithValidWord) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                answer++;
            }
        }
        return answer;
    }
}
