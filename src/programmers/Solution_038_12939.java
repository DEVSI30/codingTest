package programmers;

import java.util.Arrays;
import java.util.List;

public class Solution_038_12939 {
    public String solution(String s) {
        List<Integer> sortedIntegerList = Arrays.stream(s.split(" "))
                .map(Integer::parseInt).sorted().toList();
        return sortedIntegerList.get(0) + " " + sortedIntegerList.get(sortedIntegerList.size() - 1);
    }
}
