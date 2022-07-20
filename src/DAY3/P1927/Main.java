package DAY3.P1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, tmp, size;
    static int[] minHeap;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY3/P1927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        minHeap = new int[N];

        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (size == 0) System.out.println(0);
                else System.out.println(getRoot());
            } else {
                insert(tmp);
            }
        }
    }

    static int getRoot() {
        int parent = 1;
        int rtn = minHeap[parent];

        while (true) {
            int left = parent * 2;
            int right = parent * 2 + 1;

            if (left > size) {
                // no child
                break;
            } else if (left == size) {  // only left child
                swap(left, parent);
                parent = left;
            } else {    // both child
                if (minHeap[left] == minHeap[right]) {
                    swap(left, parent);
                    parent = left;
                } else {
                    int min = (minHeap[left] < minHeap[right]) ? left : right;
                    swap(min, parent);
                    parent = min;
                }
            }

        }
        size--;
        return rtn;
    }

    static void insert(int value) {
        minHeap[++size] = value;

        int child = size;
        int parent = size / 2;
        while (parent >= 1) {
            if (minHeap[child] < minHeap[parent])
                swap(child, parent);

            child = parent;
            parent = child / 2;
        }
        // last 에 삽입해서 root 까지 올라감
    }

    static void swap(int idx1, int idx2) {
        int tmp = minHeap[idx1];
        minHeap[idx1] = minHeap[idx2];
        minHeap[idx2] = tmp;
    }
}
