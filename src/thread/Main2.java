package thread;

public class Main2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running, thread name: " + Thread.currentThread().getName());
                throw new RuntimeException("Thread has exception!!!");
            }
        });

        thread.setName("New thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Uncaught exception: " + e);;
            }
        });
        thread.start();
    }
}
