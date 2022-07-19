package DAY2.P2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int listSize;

    static boolean sum(int list[], int check, int h) {
        long result = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] > check)
                result += list[i] - check;
        }
        if (result >= h)
            return true;
        else
            return false;
    }

    static int binarySearch(int h, int list[], int size) {
        int low = 0;
        int high = 2000000000;


        while (low <= high) {
            int mid = (low + high) / 2;
            if (sum(list, mid, h))
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        int m = Integer.parseInt(st.nextToken());

        String mc = br.readLine();
        st = new StringTokenizer(mc);
        for (int i = 0; i < n; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tree);
        listSize = tree.length;

        int res = binarySearch(m, tree, listSize);

        System.out.print(res);
    }

}