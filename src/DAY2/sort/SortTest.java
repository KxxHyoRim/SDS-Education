package DAY2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);
        Collections.sort(list); //array 정렬 하는 방법
        // 정렬 방법 1 : comparable (adj) -> 단독으로 사용못함
        // 정렬 방법 2 : comparator (n)
        System.out.println(list);

        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comparator);
        System.out.println(list);

        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed());
        System.out.println(list);
    }

}

class Item implements Comparable<Item> {
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" + "a=" + a + ", b= " + b + ", c= " + c + "}";
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    // Item 에 귀속되어 있어서 자유롭게 사용할 수 없음
    @Override
    public int compareTo(Item o) {
        /** 긴 코드 */
//        if (b < o.b) {
//            return -1;
//        } else if (b == o.b) {
//            return 0;
//        } else return 1;

        /** 간단한 코드 */
//        return o.b - b;

        /** 위치기억 하기 
         * - 헷갈리면 sample 만들어서 돌려보기 
         * - 혹은 기분 제공 comparator 사용하기 */
        return Integer.compare(b, o.b);


        /**이중 조건으로 정렬하기 */
//        if (a < o.a) {
//            return -1;
//        } else if (a == o.a) {
//            return b - o.b;
//        } else return 1;
//        -> a 먼저 정렬하고 b 로 정렬하겠다

    }
}
