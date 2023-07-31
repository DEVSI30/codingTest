package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution_080_42839 {
    private TreeSet<Integer> combinations = new TreeSet<>();
    private String numbers;
    public int solution(String numbers) {
        this.numbers = numbers;
        getCombinations("", new boolean[numbers.length()]);
        Integer max = combinations.last();
        HashSet<Integer> primaryHashSet = getPrimaryHashSet(max);

        Set<Integer> primary = new HashSet<>();

        for (Integer combination : combinations) {
            if (primaryHashSet.contains(combination)) {
                primary.add(combination);
            }
        }

        return primary.size();
    }

    public void getCombinations(String acc, boolean[] used) {
        if (!acc.isEmpty()) {
            combinations.add(Integer.parseInt(acc));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(used[i]) continue;
            used[i] = true;
            getCombinations(acc + numbers.charAt(i), used);
            used[i] = false;
        }
    }

    public HashSet<Integer> getPrimaryHashSet(int max) {
        HashSet<Integer> primarySet = new HashSet<>();

        if (max >= 2) {
            primarySet.add(2);
        }

        if (max % 2 == 0) {
            max--;
        }

        int[] numbers = new int[max / 2];
        boolean[] usedNumbers = new boolean[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 3 + 2 * i;
        }

        for (int i = 0; i < numbers.length; i++) {
            if(usedNumbers[i]) continue;

            int now = numbers[i];
            primarySet.add(now);
            int index = i;
            while (index <= numbers.length - 1) {
                usedNumbers[index] = true;
                index += now;
            }
        }

        return primarySet;
    }
}
