package thread.practices;

public class EvenOddPrinter {
    private static final int MAX = 100;
    private int number = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter();
        new Thread(printer::printOdd, "Odd-Thread").start();
        new Thread(printer::printEven, "Even-Thread").start();
    }

    public void printOdd() {
        synchronized (lock) {
            while (number <= MAX) {
                if (number % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    lock.notify();
                } else {
                    try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }
            lock.notify(); // prevent deadlock
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= MAX) {
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number++);
                    lock.notify();
                } else {
                    try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
            }
            lock.notify(); // prevent deadlock
        }
    }
}
