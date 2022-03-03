package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 사항
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다. -> day는 1부터 시작
 * 작업 속도는 100 이하의 자연수입니다. -> 최대 99일, 1일 때 1일차 2 99일차 100
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 */
public class Solution003 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> progressesStack = new Stack<>();

        // 가장 첫 번째 부터 나와야 하므로 순서를 거꾸로 넣기
        for (int i = progresses.length - 1; i >= 0; i--) {
            progressesStack.push(progresses[i]);
        }
        List<Integer> dayList = new ArrayList<>();

        int day = 0;
        int count = 0;
        while (!progressesStack.empty()) {
            Integer progressNow = progressesStack.pop();
            int i = speeds.length - progressesStack.size() - 1;
            // 진도율이 100보다 크면, 다시 집어넣지 않으니까 꺼낸거고 count + 1
            if (progressNow + speeds[i] * day >= 100) {
                count++;
            }
            else {
                // 진도율이 100 이상이 아니니까 다시 집어넣고, day를 증가시켜줌
                progressesStack.push(progressNow);
                //  진행율 30 , 속도 4, 필요는 100- 진행율 70 / 4 17.5 일 올림 18일
                day = (int) Math.ceil((double)(100-progressNow)/(double)speeds[i]);
                // 지금까지 몇 개 집어넣었는지 answer에 집어넣고 (0이면 집어넣으면 안됨)
                // count 초기화
                if (count != 0) {
                    dayList.add(count);
                    count = 0;
                }
            }

        }
        // 남은게 0이 아니면
        if (count != 0) {
            dayList.add(count);
        }

        int[] answer = new int[dayList.size()]; // 몇 개의 기능이 동시에 배포되는지 리스트

        for (int k = 0; k < dayList.size(); k++) {
            answer[k] = dayList.get(k);
        }

        return answer;
    }
}
