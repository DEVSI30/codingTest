package programmers;

import java.util.Collections;
import java.util.HashSet;

/**
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 *
 * phone_book	return
 * ["119", "97674223", "1195524421"]	false
 * ["123","456","789"]	true
 * ["12","123","1235","567","88"]	false
 *
 * 아.. 전화번호를 해쉬맵에 다 넣고 나서
 * 서브스트링으로 key가 있는지 확인하는건가?
 * 근데 굳이 해쉬 셋이구나..
 * 자기자신을 빼줘야 하는데, 동일한게 없다고 했으니까.. k를 length - 1까지만 돌리면 되겠다.
 *
 * 소요시간 34분...............
 */
public class Solution002 {
    public boolean solution(String[] phone_book) {

        HashSet<String> phoneBookSet = new HashSet<>();
        Collections.addAll(phoneBookSet, phone_book);

        for (String phoneNumber : phone_book) {
            int length = phoneNumber.length();
            for (int k = 0; k < length-1; k++) {
                String substring = phoneNumber.substring(0, k+1);
                if (phoneBookSet.contains(substring)) {
                    return false;
                }
            }
        }
        return true;
    }

}
