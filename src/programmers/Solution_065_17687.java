package programmers;

public class Solution_065_17687 {
    /**
     * 자신이 말해야 하는 숫자를 스마트폰에 미리 출력
     *
     * @param n 진법
     * @param t 미리 구할 숫자의 갯수
     * @param m 게임에 참가하는 인원
     * @param p 튜브의 순서 (1이 첫 번째)
     * @return 튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다
     */
    public String solution(int n, int t, int m, int p) {
        // t * m 짜리 배열 만들어 놓고
        // 0부터 1씩 증가하면서 진법으로 변환 후
        // 배열에 1자리씩 채워 넣기
        // 배열이 다 찰 때까지 진행
        Character[] simulationResult = new Character[t * m];

        int num = 0;
        int i = 0;
        while (i < simulationResult.length) {
            String result = convertBaseSystem(num, n);
            for (char c : result.toCharArray()) {
                if (i >= simulationResult.length) {
                    break;
                }
                simulationResult[i] = c;
                i++;
            }
            num++;
        }

        // p 번째만 선택해서 결과에 추가
        StringBuilder answer = new StringBuilder();

        for (int j = p - 1; j < simulationResult.length; j += m) {
            answer.append(simulationResult[j]);
        }

        return answer.toString();
    }

    public String convertBaseSystem(int num, int n) {
        if (n == 10) {
            return "" + num;
        }
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int mod = num % n;

            switch (mod) {
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    sb.append(mod);
            }
            num /= n;
        }

        return sb.reverse().toString();
    }
}
