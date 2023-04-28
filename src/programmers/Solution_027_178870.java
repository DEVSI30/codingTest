package programmers;

public class Solution_027_178870 {
    public int[] solution(int[] sequence, int k) {
        // 오름차순으로 정렬되어 있으니 뒤에서부터 찾는게 핵심
        int n = 0;
        int remain = k;
        for (int i = sequence.length - 1; i >= 0; i--) {
            // 왼쪽에 있는 요소로 오른쪽에 있는 요소보다 더 큰 합을 갖으려면
            // 같은 길이거나 더 긴 부분수열이 필요한 것이 핵심
            while (true) {
                remain -= sequence[i - n];
                if (remain == 0) {
                    return getAnswer(i - n, i, sequence);
                } else if (remain < 0) {
                    remain += sequence[i];
                    break;
                }
                n++;
            }
        }
        return new int[]{0, 0};
    }

    int[] getAnswer(int start, int end, int[] sequence) {
        // 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
        // 라는 문제의 조건 때문에 이런 경우가 많다고 생각할 수 있는데
        // 길이가 같은 수열이 존재하는 경우는 해당 수열의 값이 모두 동일한 경우 밖에 없음
        while (true) {
            if (start == 0) {
                return new int[]{start, end};
            }
            if (sequence[start - 1] == sequence[end]) {
                start--;
                end--;
            } else {
                return new int[]{start, end};
            }
        }
    }
}