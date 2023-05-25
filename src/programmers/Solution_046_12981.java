package programmers;

import java.util.HashSet;

public class Solution_046_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        // 중복되거나 이어지지 않는 단어의 위치를 찾고
        // n 으로 적당히 누가 몇 번째에서 실패했는지 계산한다.
        HashSet<String> usedWords = new HashSet<>();
        String lastWord = "";
        int count = 0;
        for (String word : words) {
            count++;
            if (lastWord.isEmpty()) {
                lastWord = word;
                usedWords.add(word);
                continue;
            }

            if (lastWord.charAt(lastWord.length() - 1) != word.charAt(0) || usedWords.contains(word)) {
                break;
            }

            lastWord = word;
            usedWords.add(word);
        }

        if (count == words.length && count == usedWords.size()) {
            return answer;
        }

        answer[0] = (count - 1) % n + 1;
        answer[1] = (count - 1) / n + 1;

        return answer;
    }
}
