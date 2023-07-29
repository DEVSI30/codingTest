package programmers;

import java.util.ArrayDeque;

public class Solution_078_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int passCount = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }

        int index = 0;
        int truck_weights_sum_on_bridge = 0;
        int answer = 0;
        while (passCount < truck_weights.length) {
            int waitTruckWeight = index < truck_weights.length ? truck_weights[index] : 0;
            Integer truck_out_weight = bridge.pollFirst();
            if (truck_out_weight > 0) {
                passCount++;
            }
            truck_weights_sum_on_bridge -= truck_out_weight;

            if (weight - truck_weights_sum_on_bridge >= waitTruckWeight) {
                bridge.addLast(waitTruckWeight);
                truck_weights_sum_on_bridge += waitTruckWeight;
                index++;
            } else {
                bridge.addLast(0);
            }
            answer++;
        }
        return answer;
    }
}
