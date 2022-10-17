package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_017_427842 {
    public String solution(String s) {
        List<Integer> integerList = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        return String.format("%d %d", integerList.get(0), integerList.get(integerList.size()-1));
    }
}
