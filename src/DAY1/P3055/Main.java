package DAY1.P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main {
    static int Y, X, wX, wY, sX, sY;
    static String oneLine, tmp;
    static Queue<Point> queue;
    static String[][] map;
    static int[][] dp;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean foundAnswer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY1/P3055/input.txt"));
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new String[Y][X];
        dp = new int[Y][X];     // visited
        queue = new LinkedList<>();
        Point startPoint = null;

        // input
        for (int y = 0; y < Y; y++) {
            oneLine = br.readLine();
            for (int x = 0; x < X; x++) {
                map[y][x] = st.nextToken(oneLine);
                if (map[y][x].equals("*")) {
                    queue.add(new Point(y, x, '*'));
                } else if (tmp.equals("S")) {
                    startPoint = new Point(y, x, 'S');
                }
            }
        }
        queue.add(startPoint);

        bfs();
    }

    static void bfs() {

        while (!queue.isEmpty()) {

            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = wX + dx[i];
                int nY = wY + dy[i];


                if (nX < 0 || nX > X - 1 || nY < 0 || nY > Y - 1)
                    continue;

                if (!map[nY][nX].equals("X"))
                    continue;

                if (map[nY][nX].equals("D"))
                    System.out.println("도착");

                if (map[nY][nX].equals("*"))
                    System.out.println("물");


            }
            // bfs 시작은 wY, wX에서 부터

        }

    }
}

class Point {
    int x;
    int y;
    char type;

    public Point(int y, int x, char s) {
        this.y = y;
        this.x = x;
        this.type = s;
    }
}