package programmers;

import java.util.ArrayList;
import java.util.List;


public class Solution_006_42840 {
    static class SolvePattern {
        private final int solverId;
        private final int[] pattern;
        private int score;

        public SolvePattern(int[] pattern, int solverId) {
            this.pattern = pattern;
            this.solverId = solverId;
            this.score = 0;
        }

        public void solve(int index, int answer) {
            if (pattern[index % pattern.length] == answer) {
                this.score++;
            }
        }

        public int getScore() {
            return score;
        }

        public int getSolverId() {
            return solverId;
        }
    }
    SolvePattern solvePattern1 = new SolvePattern(new int[]{1, 2, 3, 4, 5}, 1);
    SolvePattern solvePattern2 = new SolvePattern(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 2);
    SolvePattern solvePattern3 = new SolvePattern(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3);

    SolvePattern[] solvers = new SolvePattern[]{solvePattern1, solvePattern2, solvePattern3};


    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            for (SolvePattern solver : solvers) {
                solver.solve(i, answers[i]);
            }
        }

        int maxScore = -1;
        List<Integer> highScoreIdList = new ArrayList<>();
        for (SolvePattern solver : solvers) {
            if (maxScore < solver.getScore()) {
                maxScore = solver.getScore();
                highScoreIdList.clear();
            }
            if (maxScore <= solver.getScore()) {
                highScoreIdList.add(solver.getSolverId());
            }
        }

        return highScoreIdList.stream().mapToInt(i-> i).toArray();
    }
}
