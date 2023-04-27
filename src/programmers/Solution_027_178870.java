package programmers;

public class Solution_027_178870 {
    public int[] solution(int[] sequence, int k) {
        int[] sequence_sum = sequence.clone();
        int[] answer = new int[2];

        int max_index = (sequence_sum.length - 1);
        boolean max_index_changed = false;
        for (int i = 1; i <= sequence.length; i++) {
            // 시간초과가 되면 이진 탐색을 써봐라
            int min_index = 0;
            max_index_changed = false;
            while(min_index <= max_index) {
                int index = (min_index + max_index)/ 2;
                int value = sequence_sum[index];
                if(value > k) {
                    index = (min_index + index) / 2;
                    max_index = index - 1;
                }
                else if(value == k) {
                    // 근데 이진탐색을 쓰면 제일 왼쪽을 찾지를 못함
                    int minus_i = 0;
                    while(index - minus_i >= 0 && sequence_sum[index - minus_i] == value) {
                        answer[0] = index - minus_i;
                        answer[1] = index - minus_i + i - 1;
                        minus_i++;
                    }

                    return answer;
                }
                else {
                    index = (index + max_index) / 2;
                    min_index = index + 1;
                }
            }

            for (int j = 0; j < sequence_sum.length - i; j++) {
                sequence_sum[j] += sequence[j + i];
                if(sequence_sum[j] > k) {
                    max_index = j - 1;
                    max_index_changed = true;
                    break;
                }
            }
            if(!max_index_changed) {
                max_index--;
            }
        }

        return answer;
    }
}
