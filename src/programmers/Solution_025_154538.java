package programmers;

import java.util.HashSet;

public class Solution_025_154538 {
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(x);
        int times = 0;

        while (hashSet.size() != 0) {
            times++;

            HashSet<Integer> nextHashSet = new HashSet<>();

            for (Integer value : hashSet) {
                if (value * 2 == y || value * 3 == y || value + n == y) {
                    return times;
                }

                if (value * 2 < y) {
                    nextHashSet.add(value * 2);
                }

                if (value * 3 < y) {
                    nextHashSet.add(value * 3);
                }

                if (value + n < y) {
                    nextHashSet.add(value + n);
                }
            }

            hashSet = nextHashSet;
        }

        return -1;
    }
}
