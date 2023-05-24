package programmers;

public class Solution_043_12911 {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        while(true){
            n++;
            if(oneCount == Integer.bitCount(n)){
                return n;
            }
        }
    }
}
