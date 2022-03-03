package programmers;

import java.util.Arrays;

/*
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution005_42748 {
    public int[] cutArray(int[] array, int startIndex, int endIndex) {
        int[] newArray =  new int[endIndex-startIndex+1];

        for (int i = 0; i < array.length; i++) {
            if (i > endIndex) {
                break;
            }
            if (i >= startIndex) {
                newArray[i - startIndex] = array[i];
            }
        }

        return newArray;
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for (int[] command : commands) {
            int startIndex = command[0]-1;
            int endIndex = command[1]-1;
            int returnPosition = command[2]-1;
            int[] subArray = cutArray(array, startIndex, endIndex);

            int[] ints = Arrays.stream(subArray).sorted().toArray();
            answer[count] = ints[returnPosition];
            count++;
        }

        return answer;
    }
}
