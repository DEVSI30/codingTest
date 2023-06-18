package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_062_87946 {
    private int[][] originDungeons;

    public int solution(int k, int[][] dungeons) {
        originDungeons = dungeons;
        return getMaxPathLength(k, new ArrayList<>());
    }

    public int getMaxPathLength(int k, List<Integer> visited) {
        int maxLength = visited.size();

        for (int i = 0; i < originDungeons.length; i++) {
            if (visited.contains(i)) {
                continue;
            }

            int[] originDungeon = originDungeons[i];
            int minimumRequiredFatigue = originDungeon[0];
            int consumptionFatigue = originDungeon[1];

            if (k >= minimumRequiredFatigue) {
                List<Integer> newVisited = new ArrayList<>();
                for (Integer v : visited) {
                    newVisited.add(v);
                }
                newVisited.add(i);
                int newMaxLength = getMaxPathLength(k - consumptionFatigue, newVisited);

                if (newMaxLength > maxLength) {
                    maxLength = newMaxLength;
                }
            }

        }

        return maxLength;
    }
}
