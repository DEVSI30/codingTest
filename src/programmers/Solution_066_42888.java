package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_066_42888 {
    private Map<String, String> userIdAndNicknameMap = new HashMap<>();

    public String[] solution(String[] record) {
        List<History> historyList = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String historyType = split[0];
            String userId = split[1];
            switch (historyType) {
                case "Enter":
                    userIdAndNicknameMap.put(userId, split[2]);
                    historyList.add(new History(HistoryType.ENTER, userId));
                    break;
                case "Leave":
                    historyList.add(new History(HistoryType.LEAVE, userId));
                    break;
                case "Change":
                    String changedNickname = split[2];
                    userIdAndNicknameMap.put(userId, changedNickname);
                    break;
            }
        }


        String[] answer = new String[historyList.size()];

        int index = 0;
        for (History history : historyList) {
            String showMessage = userIdAndNicknameMap.get(history.userId) + "님이 " + history.historyType.message;
            answer[index] = showMessage;
            index++;
        }
        return answer;
    }

    public enum HistoryType {
        ENTER("들어왔습니다."),
        LEAVE("나갔습니다."),
        CHANGE_NICKNAME("닉네임을 변경했습니다.");

        final private String message;

        private HistoryType(String message) {
            this.message = message;
        }
    }

    private class History {
        private HistoryType historyType;
        private String userId;

        public History(HistoryType historyType, String userId) {
            this.historyType = historyType;
            this.userId = userId;
        }
    }
}
