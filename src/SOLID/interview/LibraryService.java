package SOLID.interview;

import java.util.concurrent.atomic.AtomicLong;

public class LibraryService {

    private static AtomicLong bookSeq = new AtomicLong(1);

    public static void main(String[] args) {
        long id = bookSeq.getAndIncrement();
        System.out.println(id);
        long id1 = bookSeq.getAndIncrement();
        System.out.println(id1);
        long id2 = bookSeq.getAndIncrement();
        System.out.println(id2);
    }
}
