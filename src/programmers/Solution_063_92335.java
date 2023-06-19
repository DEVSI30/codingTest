package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_063_92335 {
    /* 문제의 조건
    - n >= 1 and n <= 1,000,000
    - k >= 3 and k <= 10
     */
    public int solution(int n, int k) {
        String p = convertBaseSystem(n, k);

        /*
        0P0처럼 소수 양쪽에 0이 있는 경우
        P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
        0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
        P처럼 소수 양쪽에 아무것도 없는 경우
        단, P는 각 자릿수에 0을 포함하지 않는 소수입니다

        -> 0으로 split 해서 각각의 원소들이 소수인지만 따지면 됨
         */


        List<Long> splitList = Arrays.stream(p.split("0"))
                .filter(x -> x.length() > 0)
                .map(x -> Long.parseLong(x))
                .collect(Collectors.toList());

        /*
            110011을 10진수로 바꾸면 110011입니다.
            여기서 찾을 수 있는 조건에 맞는 소수는 11, 11 2개입니다.
            이와 같이, 중복되는 소수를 발견하더라도 모두 따로 세어야 합니다.
         */

        int answer = 0;
        for (Long sp : splitList) {
            // 1은 소수가 아님
            if (sp == 1) {
                continue;
            }

            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(sp); i++) {
                if (sp % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }

    public String convertBaseSystem(int n, int k) {
        if (k == 10) {
            return "" + n;
        }

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int mod = n % k;
            sb.append(mod);
            n /= k;
        }

        return sb.reverse().toString();
    }
}
