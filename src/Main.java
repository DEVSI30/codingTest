import programmers.Solution_031_176962;

public class Main {
    public static void main(String[] args) {
        Solution_031_176962 solution031176962 = new Solution_031_176962();

        String[] solution = solution031176962.solution(new String[][]{{"music", "12:20", "40"}, {"science", "12:40", "50"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});

        String[] strings = {"science", "history", "computer", "music"};

        System.out.println("CheckResult() = " + CheckResult(solution, strings));
    }

    public static boolean CheckResult(String[] a, String[] b){
        if(a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if(!a[i].equals(b[i])) return false;
        }

        return true;
    }
}

