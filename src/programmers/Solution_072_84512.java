package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class Solution_072_84512 {
    public int solution(String word) {
        Character[] AEIOU = new Character[]{'A', 'E', 'I', 'O', 'U'};

        List<String> wordList = new ArrayList<String>();
        List<String> lastWordList = new ArrayList();
        lastWordList.add("");
        for(int len = 1; len <=5; len++){
            lastWordList = addPostFix(lastWordList, AEIOU);
            wordList.addAll(lastWordList);
        }

        Collections.sort(wordList);
        int order = Collections.binarySearch(wordList, word);

        return order + 1;
    }

    public List<String> addPostFix(List<String> originalList, Character[] postFixList) {
        List<String> result = new ArrayList<String>();

        for(String s :originalList){
            for(Character c : postFixList){
                result.add(s + c);
            }
        }

        return result;
    }
}
