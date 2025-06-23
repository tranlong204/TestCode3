package Kafka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    static volatile Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.setName("Thread-01-Producer");
        consumer.setName("Thread-02-Consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    public static class Producer extends Thread {
        Queue<Integer> queue;

        public Producer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            Random random = new Random();

            synchronized (queue) {
                while (true) {
                    int randomInt = random.nextInt(100);
                    System.out.println("Random number generated: " + randomInt);
                    queue.add(randomInt);
                    queue.notify();
                    try {
                        queue.wait();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

    }

    public static class Consumer extends Thread {
        Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("Consumer thread started");
            synchronized (queue) {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        System.out.println("queue size: " + queue.size());
                        if (!queue.isEmpty()) {
                            System.out.println("Consumed value: " + queue.poll());
                            queue.notify();
                            queue.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}

