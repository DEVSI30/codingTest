package programmers;

public class Solution010_43238 {
    public long sumArray(long[] array){
        long total = 0L;
        for (long value : array) {
            total += value;
        }
        return total;
    }
    public long solution(int n, int[] times) {
        int maxTime = -1;
        for (int time : times) {
            if(time > maxTime){
                maxTime = time;
            }
        }

        long[] divides = new long[times.length];

        long maxPossibleTime = (long) maxTime * n;
        long minPossibleTime = 0L;

        while(sumArray(divides) != n){
            long middle = (long)Math.ceil((double)(maxPossibleTime + minPossibleTime)/2);
            for(int i = 0; i < divides.length; i++){
                divides[i] = middle / times[i];
            }
            if(sumArray(divides) == n){
                break;
            }
            else if(sumArray(divides) < n) {
                if(minPossibleTime == middle){
                    break;
                }
                minPossibleTime = middle;
            }
            else {
                if(maxPossibleTime == middle){
                    break;
                }
                maxPossibleTime = middle;
            }
        }

        long answer = 0;
        for(int i = 0; i < divides.length; i++){
            if(divides[i]*times[i] > answer) {
                answer = divides[i]*times[i];
            }
        }
        return answer;
    }
}
