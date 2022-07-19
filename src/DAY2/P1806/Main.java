package DAY2.P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY2/P1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int low = 0, high = 0, tmp = 0, result = Integer.MAX_VALUE;
        while (high <= N) {
            if (tmp < M) {
                tmp += num[high++];
            } else if (tmp > M) {
                tmp -= num[low++];
            } else {
                result = Math.min(result, high - low);
                tmp += num[high++];
            }
        }

        if (result == Integer.MAX_VALUE)
            System.out.println("0");
        else System.out.println(result);

    }
}
