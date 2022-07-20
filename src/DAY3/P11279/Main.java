//package DAY3.P11279;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int N, x, tmp, size;
//    static int[] maxHeap;
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/DAY3/P11279/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
////        st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(br.readLine());
//        x = Integer.parseInt(br.readLine());
//
//        maxHeap = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            tmp = Integer.parseInt(br.readLine());
//            if (tmp == 0) {
//                System.out.println(getRoot());
//            } else {
//                inser(tmp);
//            }
//
//        }
//    }
//
//    static int getRoot() {
//        int parent = 1;
//        int rtn = maxHeap[parent];
//        while (true) {
//            int left = parent * 2;
//            int right = parent * 2 + 1;
//
//            if (left == right)
//        }
//    }
//}
