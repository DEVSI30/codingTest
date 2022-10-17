package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_018_427842 {
    /**
     * 1, 4, 7, 8이 속하는 상자의 그룹과 2, 5, 6이 속하는 상자의 그룹과 3이 속하는 상자의 그룹이 존재합니다.
     * 따라서 3번 상자를 고르지 않았을 때, 두 번의 시행에서 3과 4를 기록하며 최고 점수 12를 얻을 수 있습니다.
     */
    public int solution(int[] cards) {
        List<Integer> groups = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        for (int card : cards) {
            groups.add(-1);
        }
        int group = 0;
        for (int i = 0; i < cards.length; i++) {
            // 이미 그룹이 매겨진 카드
            if (groups.get(i) != -1) {
                continue;
            }
            int indexNow = i;
            int size = 1;
            while (true) {
                groups.set(indexNow, group);
                int value = cards[indexNow];
                // index 2 value 3이 선택 됨 index+1 == value 이므로 루프를 탈출
                if (indexNow + 1 == value) {
                    sizes.add(size);
                    break;
                }

                // index 0 value 8 이 선택 됨 다르니까 nowIndex 는 7이 되야 함
                indexNow = value - 1;

                // 다음이 이미 열려있는 곳이라면 종료 됨
                if (groups.get(indexNow) != -1) {
                    sizes.add(size);
                    break;
                }
                size++;
            }
            group++;
        }

        if (sizes.size() == 1) {
            return 0;
        }

        return sizes
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(1, (result, x) -> result * x);
    }
}
