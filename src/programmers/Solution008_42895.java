package programmers;

import java.util.*;

public class Solution008_42895 {
    private List<Integer> stirAndFry(int A, int B) {
        List<Integer> result = new ArrayList<>();
        result.add(A + B);
        result.add(A * B);
        if (A > B) { // n <=0은 필요 없다. number >= 1 이고 최소비용을 구하는 것 이므로
            result.add(A - B);
            result.add(A / B);
        }

        return result;
    }

    public int solution(int N, int number) {
        Set<Integer> shortestPathsAlreadyFound = new HashSet<Integer>(){};
        Map<Integer, List<Integer>> nPathNumberList = new HashMap<Integer, List<Integer>>(){{
            for (int i = 1; i <= 8; i++) {
                put(i, new ArrayList<>());
            }
        }};

        if (number == 1) {
            return 2;
        }
        shortestPathsAlreadyFound.add(1);
        nPathNumberList.get(2).add(1);

        // N이 반복되는 숫자 먼저 처리
        int sum = 0;
        for (int i = 1; i <= 8; i++) {
            sum += N;
            shortestPathsAlreadyFound.add(sum);
            nPathNumberList.get(i).add(sum);
            if (sum == number) {
                return i;
            }
            sum *= 10;
        }

        // 5중 for 문 이게 최선 입니까?
        for (int n = 2; n <= 8; n++) {
            for (int k = 1; k < n; k++) {
                for (Integer n_n : nPathNumberList.get((n - k))) {
                    for (Integer k_n : nPathNumberList.get(k)) {
                        for (Integer integer : stirAndFry(n_n, k_n)) {
                            if (integer == number) {
                                return n;
                            }
                            if (n != 8 && !shortestPathsAlreadyFound.contains(integer)) {
                                shortestPathsAlreadyFound.add(integer);
                                nPathNumberList.get(n).add(integer);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
