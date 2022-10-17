package programmers;

public class Solution_019_427878 {
    public int getNext(int n) {
        if (n % 2 == 0) {
            return n/2;
        }

        return (n+1)/2;
    }
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        while (true) {
            if (bigger % 2 == 0 && (bigger - smaller) == 1) {
                break;
            }
            smaller = getNext(smaller);
            bigger = getNext(bigger);
            answer++;
        }

        return answer;
    }
}
