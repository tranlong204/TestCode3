package collections;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 2, 3, 1);
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        ListIterator<Integer> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }

        System.out.println();
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
    }
}
