package programmers;

public class Solution_041_70129 {
    public int[] solution(String s) {
        int transformCount = 0;
        int removeZeroCountTotal = 0;
        while (s.length() > 1) {
            int removeZeroCount = countZeros(s);
            int newLength = s.length() - removeZeroCount;
            s = convertLengthToBinary(newLength);

            removeZeroCountTotal += removeZeroCount;
            transformCount++;
        }
        return new int[]{transformCount, removeZeroCountTotal};
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }

    private String convertLengthToBinary(int length) {
        StringBuilder result = new StringBuilder();

        while (length > 0) {
            result.append(length % 2);
            length /= 2;
        }
        return result.reverse().toString();
    }
}
