package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_009_43165 {
    // BFS 는 Queue 로 한다.
    public int solution(int[] numbers, int target) {
        Queue<Integer> que = new LinkedList<>();
        que.add(0);

        int remain = 0;
        for (int number : numbers) {
            remain += number;
        }

        int getSize = 1;
        int newGetSize;
        for (int number : numbers) {
            newGetSize = 0;
            remain -= number;
            for (int i = 0; i < getSize; i++) {
                if(que.isEmpty()){
                    break;
                }
                Integer poll = que.poll();
                // 더 했는데 나머지를 다 빼도 Target 보다 크면 넣으면 안됨
                if (poll + number - remain <= target) {
                    que.add(poll + number);
                    newGetSize++;
                }
                // 뺐는데 나머지를 다 더해도 Target에 도달하지 못하면 넣으면 안됨
                if (poll - number + remain >= target) {
                    que.add(poll - number);
                    newGetSize++;
                }
            }
            getSize = newGetSize;
        }

        return Collections.frequency(Arrays.asList(que.toArray()), target);
    }
}
