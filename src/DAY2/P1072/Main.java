package DAY2.P1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY2/P1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int z = 100 / Y * X;

        if (z >= 99) {
            System.out.println(-1);
        } else {
            long start = 0;
            long end = X;
            while (start < end) {
                long mid = (start + end) / 2;

            }
        }
    }
}
