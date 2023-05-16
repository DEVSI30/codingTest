package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_039_12951 {
    public String solution(String s) {
        List<String> jadenCaseStrings = Arrays.stream(s.split(" ")).map(this::getJadenCase).collect(Collectors.toList());
        return String.join(" ", jadenCaseStrings) + (s.charAt(s.length() - 1) == ' ' ? " " : "");
    }

    public String getJadenCase(String s) {
        if (s.length() >= 1) {
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        }
        return s;
    }
}
