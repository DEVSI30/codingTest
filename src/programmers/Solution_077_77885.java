package programmers;

public class Solution_077_77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getBiggerAndDiffBitCount1Or2(numbers[i]);
        }

        return answer;
    }

    // 끝에 연속 된 1이 N 개 있는 경우 2^(n-1) 을 더한 수
    // 그 외에는 + 1
    // 끝에 연속 된 1의 갯수를 알기 위해서는 number % 2 가 1 이면 number 를 2로 나누고 0이 될 때까지 반복횟수
    public long getBiggerAndDiffBitCount1Or2(long number) {
        if (number % 2 == 0) return number + 1;

        int count = 0;
        long numberCopy = number;
        while (numberCopy % 2 == 1) {
            numberCopy /= 2;
            count++;
        }

        return number + (long) Math.pow(2, count - 1);
    }
}
