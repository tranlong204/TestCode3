package thread2;

public class Block {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.interrupt();
        thread.start();
    }

    private static class BlockingTask implements Runnable {


        @Override
        public void run() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
