package programmers;

import java.util.PriorityQueue;

public class Solution015_42584{
    static class StockPriceAtTime implements Comparable<StockPriceAtTime>{
        private final int time;
        private final int price;

        public StockPriceAtTime(int time, int price) {
            this.time = time;
            this.price = price;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(StockPriceAtTime o) {
            if (this.price > o.price) {
                return -1;
            } else if (this.price < o.price) {
                return 1;
            }
            return 0;
        }
    }
    public int[] solution(int[] prices) {
        PriorityQueue<StockPriceAtTime> pq = new PriorityQueue<>();
        int[] answer = new int[prices.length];

        for (int currentTime = 0; currentTime < prices.length; currentTime++) {
            answer[currentTime] = prices.length - currentTime - 1;
            int price = prices[currentTime];
            pq.add(new StockPriceAtTime(currentTime, price));
            StockPriceAtTime peek = pq.peek();
            while (peek.price > price) {
                int time = peek.getTime();
                answer[time] = currentTime - time;
                pq.poll();
                peek = pq.peek();
            }

        }

        return answer;
    }
}
