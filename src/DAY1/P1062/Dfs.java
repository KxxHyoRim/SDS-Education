package DAY1.P1062;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dfs {
    static int N, K, result;
    static String[] words;
    static boolean[] visit = new boolean[27];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY1/P1062/input.txt"));
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
//            words[i] = tmp.substring(4, tmp.length() - 4);
            words[i] = tmp.replaceAll("[antic]", "");
        }

        // System.out.println(Arrays.toString(words));

        result = checkCount();

        visit['a' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['c' - 'a'] = true;
        dfs(0, 5);

        System.out.println(result);
    }

    static void dfs(int start, int size) {
        // 1. 체크인
        visit[start] = true;

        // 2. 목적지인가
        if (size == K) {
            result = Math.max(result, checkCount());
            return;
        }

        // 3. 연결된 곳을 순회
        for (int i = start + 1; i < 26; i++) {
            // 4. 갈 수 있는가?
            if (!visit[i]) {
                // 5. 간다
                dfs(i, size + 1);
            }
        }

        // 6. 체크아웃
        visit[start] = false;
    }

    static int checkCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean canRead = true;
            for (int j = 0; j < words[i].length(); j++)
                if (!visit[words[i].charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            if (canRead) count++;
        }
        return count;
    }
}
