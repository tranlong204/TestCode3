package Functional;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ComparableLambda {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(5);
        queue.add(9);
        queue.add(4);
        queue.add(10);
        System.out.println(queue.poll());
    }
}
