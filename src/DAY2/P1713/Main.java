package DAY2.P1713;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R;

    // 학생 객체 만들고 (학생번호, 추천수, 시간)
    // comparable은 학생을 위해서, 출력은 comparator 사용해보기
    // 10시반에 풀이 진행함
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY2/P1713/input.txt"));
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        Student[] students = new Student[101];

        st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 0; i < R; i++) {
            num = Integer.parseInt(st.nextToken());
            if (students[num] == null) {
                students[num] = new Student(num, 0, 0, false);
            }

            // 해당 후보가 최초 호출 시
            // 해당 후보가 사진들에 있을 경우
            if (students[num].isIn) {
                students[num].rec++;
            } else {
                if (list.size() == N) {
                    // 정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    Student removeStudent = list.remove(0); //내림차순 + 뒤에서부터 빼기 하면 더 효율적
                    removeStudent.isIn = false;
                }
                students[num].rec = 1;
                students[num].isIn = true;
                students[num].timeStamp = i;
                list.add(students[num]);
            }
        }

        list.sort(Comparator.comparingInt(o -> o.num));
        for (int i = 0; i <N; i++){
            System.out.print(list.get(i).num + " ");
        }
    }
}


class Student implements Comparable<Student> {
    int num;
    int timeStamp;
    int rec;
    boolean isIn; /* 생각 못함 */

    public Student(int num, int timeStamp, int rec, boolean isIn) {
        this.num = num;
        this.timeStamp = timeStamp;
        this.rec = rec;
        this.isIn = isIn;
    }

    @Override
    public String toString() {
        return "Student{" + "num=" + num + ", duration=" + timeStamp +
                ", rec=" + rec + ", isIn=" + isIn + '}';
    }

    @Override
    public int compareTo(Student o) {
        // 추천수, 시간
        int comp = Integer.compare(rec, o.rec);
        if (comp == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else return comp;
        // 제일 앞에 있는 애는 표도 적고, 같을지라도 가장 먼저 들어온 애
    }
}