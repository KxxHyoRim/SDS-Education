package DAY2.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY2/P2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // INPUT START ==============================
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());
        // INPUT END ==============================

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long sum = A[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }

        for (int i = 0; i < M; i++) {
            long sum = B[i];
            subB.add(sum);
            for (int j = i + 1; j < M; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }

        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA = 0, ptB = 0;

        while (true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;

            if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA) {
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            } else if (subB.get(ptB) > target) {
                ptB++;
            } else {
                ptA++;
            }

            // 탈출 조건
            if (ptA == subA.size() || ptB == subB.size()) break;

        }

        System.out.println(result);


    }
}
