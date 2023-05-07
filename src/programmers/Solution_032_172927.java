package programmers;

import java.util.*;

public class Solution_032_172927 {
    private final static String DIAMOND = "diamond";
    private final static String IRON = "iron";
    private final static String STONE = "stone";

    private final static int JOB_SIZE = 5;

    public int solution(int[] picks, String[] minerals) {
        PickSolution pickSolution = new PickSolution(picks);
        return pickSolution.calculateMinimumCost(mineralsArrayToJobList(minerals));
    }


    static class PickSolution {
        int diaPicks;
        int ironPicks;
        int stonePicks;

        public PickSolution(int[] picks) {
            diaPicks = picks[0];
            ironPicks = picks[1];
            stonePicks = picks[2];
        }

        public int calculateMinimumCost(List<Job> jobs) {
            // 주어진 곡괭이로 캘 수 있는 작업량을 초과한 작업을 빼준다
            if(jobs.size() > (diaPicks + ironPicks + stonePicks)){
                jobs = jobs.subList(0, diaPicks + ironPicks + stonePicks);
            }

            jobs.sort(Comparator.comparingInt(x -> x.costStonePick));
            Collections.reverse(jobs);

            int minimumCost = 0;

            for (Job job : jobs) {
                if (diaPicks > 0) {
                    minimumCost += job.costDiaPick;
                    diaPicks--;
                } else if (ironPicks > 0) {
                    minimumCost += job.costIroPick;
                    ironPicks--;
                } else if (stonePicks > 0) {
                    minimumCost += job.costStonePick;
                    stonePicks--;
                } else {
                    break;
                }
            }
            return minimumCost;
        }
    }

    static class Job {
        int costDiaPick = 0;
        int costIroPick = 0;
        int costStonePick = 0;

        public Job(List<String> minerals) {
            for (String mineral : minerals) {
                switch (mineral) {
                    case DIAMOND:
                        costDiaPick += 1;
                        costIroPick += 5;
                        costStonePick += 25;
                        break;
                    case IRON:
                        costDiaPick += 1;
                        costIroPick += 1;
                        costStonePick += 5;
                        break;
                    case STONE:
                        costDiaPick += 1;
                        costIroPick += 1;
                        costStonePick += 1;
                        break;
                }
            }
        }
    }

    private List<Job> mineralsArrayToJobList(String[] minerals) {
        List<Job> jobList = new ArrayList<>();

        int startIndex = 0;
        int endIndex = JOB_SIZE;
        while (true) {
            List<String> subMinerals = new ArrayList<>(JOB_SIZE);
            subMinerals.addAll(Arrays.asList(minerals).subList(startIndex, endIndex));
            jobList.add(new Job(subMinerals));

            // 끝에 도달하면 while 문을 종료
            if (endIndex >= minerals.length) break;

            startIndex += JOB_SIZE;
            endIndex = Math.min(minerals.length, endIndex + JOB_SIZE);
        }
        return jobList;
    }
}
