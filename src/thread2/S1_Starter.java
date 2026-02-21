package thread2;

import java.util.concurrent.Callable;

public class S1_Starter {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current priority is " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread " + Thread.currentThread().getName() + " before starting a new thread");

        thread.start();
        System.out.println("We are in thread " + Thread.currentThread().getName() + " after starting a new thread");

    }
}
