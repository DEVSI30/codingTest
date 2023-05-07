package programmers;

import java.util.ArrayList;
import java.util.List;

/*
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

1번부터 끝 번호까지 가면서 없는 사람은 왼쪽 사람에게 요구 후 없으면 오른쪽 사람에게 요구
 */
public class Solution_007_42862 {
    static class Student{
        Student prevStudent;
        Student nextStudent;
        Boolean lostYn;
        Boolean reserveYn;
        Boolean isHaveSportWear;

        public Student() {
        }

        public Student(Student prevStudent, Boolean lostYn, Boolean reserveYn, Boolean isHaveSportWear) {
            this.prevStudent = prevStudent;
            this.nextStudent = null;
            this.lostYn = lostYn;
            this.reserveYn = reserveYn;
            this.isHaveSportWear = isHaveSportWear;
        }

        public Boolean getLostYn() {
            return lostYn;
        }

        public void setLostYn(Boolean lostYn) {
            this.lostYn = lostYn;
        }

        public Boolean getReserveYn() {
            return reserveYn;
        }

        public void setReserveYn(Boolean reserveYn) {
            this.reserveYn = reserveYn;
        }

        public void setHaveSportWear(Boolean haveSportWear) {
            isHaveSportWear = haveSportWear;
        }

        public void borrow() {
            // 왼쪽 학생이 있고, 빌려줄 수 있다면
            if (this.prevStudent != null && this.prevStudent.getReserveYn()) {
                this.prevStudent.setReserveYn(false);
                this.setHaveSportWear(true);
                // 오른쪽 학생이 있고, 빌려줄 수 있다면
            } else if (this.nextStudent != null && this.nextStudent.getReserveYn()) {
                this.nextStudent.setReserveYn(false);
                this.setHaveSportWear(true);
            }
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        List<Student> students = new ArrayList<>();
        Student firstStudent = new Student(null, false, false, true);
        students.add(firstStudent);

        Student studentPointer = firstStudent;
        for (int i = 0; i < n - 1; i++) {
            Student newStudent = new Student(studentPointer, false, false, true);
            students.add(newStudent);
            studentPointer.nextStudent = newStudent;

            studentPointer = newStudent;

        }

        for (int lostNo : lost) {
            students.get(lostNo-1).setLostYn(true);
            students.get(lostNo-1).setHaveSportWear(false);
        }

        for (int reserveNo : reserve) {
            Student reserveStudent = students.get(reserveNo-1);
            if (reserveStudent.getLostYn()) {
                reserveStudent.setLostYn(false);
                reserveStudent.setHaveSportWear(true);
            }
            else {
                reserveStudent.setReserveYn(true);
            }

        }

        int answer = 0;
        for (Student student : students) {
            if (!student.isHaveSportWear) {
                student.borrow();
            }
            if (student.isHaveSportWear) {
                answer++;
            }
        }

        return answer;
    }
}
