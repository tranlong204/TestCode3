package thread;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " is running");
                    System.out.println("Priority = " + Thread.currentThread().getPriority());
                }
        );

        thread.setName("New worker thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Before start thread " + thread.getName() );
        thread.start();
        System.out.println("After start thread " + thread.getName() );
    }
}
