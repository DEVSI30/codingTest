package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_031_176962 {
    public String[] solution(String[][] plans) {
        Deque<Plan> planDequeSorted = Arrays.stream(plans)
                .map(Plan::new)
                .sorted(Comparator.comparingInt(x -> x.startTime))
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<String> finishedPlanNames = new ArrayList<>(plans.length);
        Deque<Plan> unFinishedPlans = new ArrayDeque<>();

        while(!planDequeSorted.isEmpty()){
            Plan plan = planDequeSorted.poll();
            Plan nextPlan = planDequeSorted.isEmpty() ? null : planDequeSorted.peekFirst();
            int nextPlanStartTime = nextPlan == null ? Integer.MAX_VALUE : nextPlan.startTime;

            if(nextPlanStartTime >= plan.endTime) {
                finishedPlanNames.add(plan.name);
                int termTime = nextPlanStartTime - plan.endTime;
                processUnfinishedPlans(termTime, unFinishedPlans, finishedPlanNames);
            }
            else{
                plan.remainTime -= nextPlanStartTime - plan.startTime;
                unFinishedPlans.addLast(plan);
            }

        }
        return finishedPlanNames.toArray(new String[0]);
    }

    private static class Plan {
        public final String name;
        public final int startTime;
        public final int playTime;
        public int remainTime;
        public int endTime;

        public Plan(String[] planArray) {
            name = planArray[0];
            startTime = getStartTime(planArray[1]);
            playTime = Integer.parseInt(planArray[2]);
            remainTime = playTime;
            endTime = startTime + playTime;
        }

        private int getStartTime(String timeStr) {
            String[] split = timeStr.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
    }

    /*
    다음 계획이 시작되서 완료하지 못했던 계획들을 다음계획 시작시간 까지 남은 시간을 활용해서 처리한다
     */
    private void processUnfinishedPlans(int termTime, Deque<Plan> unFinishedPlans, List<String> finishedPlanNames) {
        if (unFinishedPlans.isEmpty()) {
            return;
        }

        while (termTime > 0 && !unFinishedPlans.isEmpty()) {
            Plan unFinishedPlan = unFinishedPlans.removeLast(); // 최근 작업부터 처리한다
            if (termTime >= unFinishedPlan.remainTime) {
                termTime -= unFinishedPlan.remainTime;
                finishedPlanNames.add(unFinishedPlan.name);
            } else {
                unFinishedPlan.remainTime -= termTime;
                unFinishedPlans.addLast(unFinishedPlan);
                break;
            }
        }
    }
}
