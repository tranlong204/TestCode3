package thread.s3.Daemon.DaemonTest;

import DesignPatterns.observer.ProductService;

import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new UserThread());

        Thread t2 = new Thread(new DaemonThread());
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }

    private static class DaemonThread implements Runnable {

        @Override
        public void run() {
            // Checking whether the thread is Daemon or not
//            if (Thread.currentThread().isDaemon()) {
//                System.out.println(Thread.currentThread().getName() + " is Daemon thread");
//            }
//            else {
//                System.out.println(Thread.currentThread().getName() + " is User thread");
//            }

            try {
                Thread.sleep(2000);
                System.out.println("DaemonThread");
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static class UserThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("UserThread");
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
