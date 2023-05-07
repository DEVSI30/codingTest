package programmers;

import java.util.HashSet;

public class Solution_014_1845 {
    public int solution(int[] nums) {
        int N = nums.length;
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }

        return Math.min(N/2, integers.size());
    }
}
