package DAY2.P2003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /* 45분에 */
    // sum 이 target보다 작으면 high를 늘려주고, 크면 low를 올림
    // 같으면 answer++ 해줌
    //  -> 둘다 올려주면됨
    // High 에서 index 에러가 나면 끝내면 됨! (low를 올려도 값은 작아지기만 하니까 확인할 필요 없음)
    // 이런 기법을 sliding window 라고 함

    static int N, M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY2/P2003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int low = 0, high = 0, tmp = 0, result = 0;
        while (high <= N) {
            if (tmp < M) {
                tmp += num[high++];
            } else if (tmp > M) {
                tmp -= num[low++];
            } else {
                result++;
                tmp += num[high++];
            }
        }

        System.out.println(result);

    }
}
