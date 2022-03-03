package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 내 생각, 맵을 만들고, participant 에서 이름을 얻어와서, 키가 없으면 만들고, 값을 1로 초기화 한다.
 * 있으면 값을 +1 한다.
 * completion 에서 이름을 읽어와서 -1씩 한다.
 * count가 0이 되면 키를 맵에서 삭제한다.
 * 마지막에 남은 key가 완주하지 못한 선수
 * 공간을 절약하기 위해서, 둘이 동시에 실행 시키는건 어떤가?
 */
public class Solution001 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> playerMap = new HashMap<>();

        for (String p : participant) {
            if (!playerMap.containsKey(p)) {
                playerMap.put(p, 1);
            } else {
                playerMap.put(p, playerMap.get(p) + 1);
            }
        }

        for (String c : completion) {
            Integer count = playerMap.get(c);
            if (count == 1) {
                playerMap.remove(c);
            }
            else {
                playerMap.put(c, playerMap.get(c) - 1);
            }
        }

        return playerMap.keySet().iterator().next();
    }
}
