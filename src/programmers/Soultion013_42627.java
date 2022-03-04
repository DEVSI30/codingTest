package programmers;

import java.util.ArrayList;
import java.util.List;

public class Soultion013_42627 {
    static class Disk {
        private final int index;
        private final int requestTime;
        private final int executionTime;

        public Disk(int[] job, int index) {
            this.index = index;
            this.requestTime = job[0];
            this.executionTime = job[1];
        }

        public Disk(Disk o) {
            this.index = o.getIndex();
            this.requestTime = o.getRequestTime();
            this.executionTime = o.getExecutionTime();
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getExecutionTime() {
            return executionTime;
        }

        public int getIndex() {
            return index;
        }
    }

    static class DiskController {
        private static final int MAX_REQUEST_TIME = 1000;
        private static final int MAX_EXECUTION_TIME = 1000;

        private final List<Disk> diskList;

        public DiskController(int[][] jobs) {
            this.diskList = new ArrayList<>();

            for (int i = 0; i < jobs.length; i++) {
                diskList.add(new Disk(jobs[i], i));
            }
        }

        public List<Disk> getDiskListRequestTimeEarlierThenCurrentTime(int currentTime) {
            List<Disk> result = new ArrayList<>();

            for (Disk disk : this.diskList) {
                if (disk.requestTime <= currentTime) {
                    result.add(disk);
                }
            }

            return result;
        }

        private void remove(int index) {
            for (int i = 0; i < diskList.size(); i++) {
                if (diskList.get(i).getIndex() == index) {
                    diskList.remove(i);
                    break;
                }
            }
        }

        public Disk popDiskFastestExecutionTime(List<Disk> diskList) {
            int fastestExecutionTime = MAX_EXECUTION_TIME + 1;
            int fastestIndex = -1;
            for (int i = 0; i < diskList.size(); i++) {
                int executionTime = diskList.get(i).getExecutionTime();
                if (executionTime < fastestExecutionTime) {
                    fastestExecutionTime = executionTime;
                    fastestIndex = i;
                }
            }

            Disk fastestExecutionTimeDisk = new Disk(diskList.get(fastestIndex));
            remove(fastestExecutionTimeDisk.getIndex());

            return fastestExecutionTimeDisk;
        }

        public int getEarliestRequestTime() {
            int minRequestTime = MAX_REQUEST_TIME + 1;

            for (Disk disk : diskList) {
                if (disk.getRequestTime() < minRequestTime) {
                    minRequestTime = disk.getRequestTime();
                }
            }

            return minRequestTime;
        }

        public void addDisk(Disk disk) {
            diskList.add(disk);
        }

        public boolean isEmpty() {
            return diskList.isEmpty();
        }

    }
    public int solution(int[][] jobs) {
        // 현재시간 (초기값 0)
        // 현재시간을 주면, 현재시간보다 리퀘스트 타임이 같거나 작은 목록을 꺼내
        // 목록이 없어 그러면 현재시간을 제일빠른 요청시간으로 변경을 해
        // 목록이 있으면 거기서 duration이 가장 작은걸 꺼내서 수행
        // "수행" : 현재시간에 수행한 DISK의 지속시간을 더한다.
        //       : 현재시간 - DISK 의 요청시간 을 SUM에 더한다
        // diskList 가 빌 때 까지

        // 그게 아니라
        // 배열을 요청으로 정렬 해 놓고
        // while문을 도는데, 현재시간 보다 작거나 같을 때 까지만 돌고
        // 비어있으면 정렬된 상태에서 가장 작은 요청시간을 현재시간으로 바꾸고
        // 다시 돈다. ...

        int currentTime = 0;
        int sumOfWaitingTime = 0;

        DiskController controller = new DiskController(jobs);

        while (!controller.isEmpty()) {
            List<Disk> disks = controller.getDiskListRequestTimeEarlierThenCurrentTime(currentTime);

            if (disks.size() == 0) {
                currentTime = controller.getEarliestRequestTime();
                continue;
            }

            Disk disk = controller.popDiskFastestExecutionTime(disks);
            currentTime += disk.getExecutionTime();
            sumOfWaitingTime += currentTime - disk.getRequestTime();
        }

        return sumOfWaitingTime / jobs.length;
    }
}
