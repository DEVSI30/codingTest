package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_073_17686 {
    public String[] solution(String[] files) {
        List<FileInfo> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            fileList.add(new FileInfo(files[i], i));
        }

        return fileList.stream().sorted().map(x -> x.originalFileName).collect(Collectors.toList()).toArray(new String[fileList.size()]);
    }

    // HEAD 는 숫자가 아닌 문자로 이루어져 있으며 최소한 한글자 이상이다.
    // Number 는 한 글자에서 최대 다섯글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다.
    // TAIL 은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수 있으며, 아무 글자도 없을 수 있다.
    public static class FileInfo implements Comparable<FileInfo> {
        private final String originalFileName;
        private final String head;
        private final int number;
        private final int insertOrder;

        public FileInfo(String fileName, int insertOrder) {
            this.originalFileName = fileName;
            this.insertOrder = insertOrder;
            this.head = extractHeader(fileName);
            this.number = extractNumber(fileName, this.head);
        }

        private String extractHeader(String fileName) {
            int endIndex = 0;
            for (char c : fileName.toCharArray()) {
                if (Character.isDigit(c)) {
                    break;
                }
                endIndex++;
            }
            return fileName.substring(0, endIndex).toUpperCase();
        }

        private int extractNumber(String fileName, String head) {
            int startIndex = head.length();
            int endIndex;
            for (endIndex = startIndex; endIndex < fileName.length(); endIndex++) {
                if (!Character.isDigit(fileName.charAt(endIndex))) {
                    break;
                }
            }
            return Integer.parseInt(fileName.substring(startIndex, endIndex));
        }

        @Override
        public int compareTo(FileInfo o) {
            // 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다 (대소문자는 구분하지 않는다.)
            if (!this.head.equals(o.head)) {
                return this.head.compareTo(o.head);
            }

            // 파일명의 HEAD 부분이 대소문자 차이 외에는 같은 경우 NUMBER의 숫자 순으로 정렬된다.
            if (this.head.equals(o.head) && this.number != o.number) {
                return this.number - o.number;
            }

            // 두 파일의 HEAD 부분과 NUMBER 숫자도 같은 경우, 원래 입력순서를 유지한다.
            return this.insertOrder - o.insertOrder;
        }
    }
}
