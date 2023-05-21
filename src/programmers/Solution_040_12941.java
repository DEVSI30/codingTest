package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_040_12941 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> pqa = new PriorityQueue<>();
        PriorityQueue<Integer> pqb = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            pqa.add(A[i]);
            pqb.add(B[i]);
        }

        while(!pqa.isEmpty()){
            answer += pqa.poll() * pqb.poll();
        }

        return answer;
    }
}
