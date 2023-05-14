package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_036_155651 {
    public int solution(String[][] book_time) {
        HotelManager hotelManager = new HotelManager();
        hotelManager.parseBookedListOrderByStartTimeAsc(book_time);
        return hotelManager.getMinimumRoomCount();
    }

    static class HotelManager {
        PriorityQueue<Room> useRooms = new PriorityQueue<>();
        Deque<Room> availableRooms = new ArrayDeque<>();
        List<Room> reservationList = new ArrayList<>();

        public void parseBookedListOrderByStartTimeAsc(String[][] book_time){
            reservationList = Arrays.stream(book_time)
                    .map(x -> new Room(x[0], x[1]))
                    .sorted(Comparator.comparingInt(x -> x.startTime))
                    .collect(Collectors.toList());
        }

        private int getMinimumRoomCount() {
            for (Room reservation : reservationList) {
                while(true) {
                    if(useRooms.isEmpty()) {
                        break;
                    }
                    // 현재 들어온 손님의 입장 시간 보다 일찍(또는 같게) 이용이 끝나는 방을
                    // 대여 가능한 목록에 추가 한다.
                    Room peek = useRooms.peek();
                    if(peek.endTime <= reservation.startTime) {
                        availableRooms.addLast(useRooms.poll());
                    }
                    else {
                        break;
                    }
                }

                // 가능한 방이 남아 있지 않다면 useRooms 새로운 방을 추가 한다
                if (availableRooms.isEmpty()) {
                    useRooms.add(reservation);
                } else {
                    // 사용 가능한 방이 있다면 꺼내서 손님 에게 준다
                    Room cleanedRoom = availableRooms.poll();
                    cleanedRoom.getNewGuest(reservation.startTime, reservation.endTime);
                    useRooms.add(cleanedRoom);
                }

            }

            // 사용 중인 방의 갯수와 가능한 방의 갯수가 모든 손님을 지연 없이 받는 최소한 갯수
            return (int) (availableRooms.stream().count() + useRooms.size());
        }
    }

    static class Room implements Comparable<Room> {
        private int startTime;
        private int endTime;

        public Room(String startTime, String endTime) {
            this.startTime = timeToInt(startTime);
            this.endTime = timeToInt(endTime) + 10;
        }

        public void getNewGuest(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        static int timeToInt(String time) {
            String hour = time.split(":")[0];
            String minute = time.split(":")[1];
            return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
        }

        @Override
        public int compareTo(Room o) {
            return Integer.compare(this.endTime, o.endTime);
        }
    }
}
