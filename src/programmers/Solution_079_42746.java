package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_079_42746 {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(MyNumber::new)
                .sorted()
                .map(x -> x.stringNumber)
                .collect(Collectors.joining());

        // 정답이 00 일 수 있어서 0으로 시작하면 0으로 바꿔줌
        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }

    // 정렬해서 붙이면 된다.
    // 두 개를 비교할 때 더 큰 숫자가 나오게 비교하는게
    // 전체를 봤을 때에도 최적의 해답이 된다.
    public class MyNumber implements Comparable<MyNumber> {
        String stringNumber;

        public MyNumber(int i) {
            this.stringNumber = String.valueOf(i);
        }

        @Override
        public int compareTo(MyNumber o) {
            int n1 = Integer.parseInt(this.stringNumber + o.stringNumber);
            int n2 = Integer.parseInt(o.stringNumber + this.stringNumber);

            return Integer.compare(n1, n2) * -1;
        }
    }
}
