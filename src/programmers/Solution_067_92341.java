package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution_067_92341 {
    public int[] solution(int[] fees, String[] records) {
        ParkingFee parkingFee = new ParkingFee(fees);
        Map<String, ParkingHistory> parkingHistoryMap = new HashMap<>();
        Map<String, Integer> parkingTimeMap = new TreeMap<>();

        for (String record : records) {
            ParkingHistory parkingHistory = new ParkingHistory(record);
            String carNumber = parkingHistory.carNumber;

            if (parkingHistory.parkingHistoryType.equals(ParkingHistoryType.IN)) {
                parkingHistoryMap.put(carNumber, parkingHistory);
            } else {
                ParkingHistory parkingHistoryIn = parkingHistoryMap.get(carNumber);
                int time = parkingHistory.inOutTime - parkingHistoryIn.inOutTime;

                if (parkingTimeMap.containsKey(carNumber)) {
                    parkingTimeMap.put(carNumber, parkingTimeMap.get(carNumber) + time);
                } else {
                    parkingTimeMap.put(carNumber, time);
                }

                parkingHistoryMap.remove(carNumber);
            }
        }

        // 아직 안 나간 차 처리
        for (String key : parkingHistoryMap.keySet()) {
            ParkingHistory parkingHistoryIn = parkingHistoryMap.get(key);
            ParkingHistory parkingHistoryOut = new ParkingHistory(parkingHistoryIn);
            String carNumber = parkingHistoryIn.carNumber;
            int time = parkingHistoryOut.inOutTime - parkingHistoryIn.inOutTime;

            if (parkingTimeMap.containsKey(carNumber)) {
                parkingTimeMap.put(carNumber, parkingTimeMap.get(carNumber) + time);
            } else {
                parkingTimeMap.put(carNumber, time);
            }
        }

        int[] answer = new int[parkingTimeMap.keySet().size()];
        int index = 0;
        for (String key : parkingTimeMap.keySet()) {
            answer[index] = calculateParkingFee(parkingTimeMap.get(key), parkingFee);
            index++;
        }

        return answer;
    }

    public enum ParkingHistoryType {
        IN, OUT
    }

    public class ParkingFee {
        private int defaultTime;
        private int defaultFee;
        private int perMinute;
        private int perFee;

        public ParkingFee(int[] fees) {
            this.defaultTime = fees[0];
            this.defaultFee = fees[1];
            this.perMinute = fees[2];
            this.perFee = fees[3];
        }
    }

    public class ParkingHistory {
        private String carNumber;
        private int inOutTime;
        private ParkingHistoryType parkingHistoryType;

        ParkingHistory(String record) {
            String[] recordSplit = record.split(" ");
            this.inOutTime = getTimeStringToInOutTime(recordSplit[0]);
            this.carNumber = recordSplit[1];

            if (recordSplit[2].equals("IN")) {
                this.parkingHistoryType = ParkingHistoryType.IN;
            } else {
                this.parkingHistoryType = ParkingHistoryType.OUT;
            }
        }

        public ParkingHistory(ParkingHistory parkingHistoryIn) {
            this.carNumber = parkingHistoryIn.carNumber;
            this.inOutTime = 23 * 60 + 59;
            this.parkingHistoryType = ParkingHistoryType.OUT;
        }

        private int getTimeStringToInOutTime(String timeString) {
            String[] timeStringSplit = timeString.split(":");
            String hour = timeStringSplit[0];
            String minute = timeStringSplit[1];

            return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
        }
    }

    public int calculateParkingFee(int parkingTime, ParkingFee parkingFee) {
        if (parkingTime <= parkingFee.defaultTime) {
            return parkingFee.defaultFee;
        }

        return parkingFee.defaultFee + (int) Math.ceil((double) (parkingTime - parkingFee.defaultTime) / (double) parkingFee.perMinute) * parkingFee.perFee;
    }
}
