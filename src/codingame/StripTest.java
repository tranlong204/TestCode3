package codingame;

public class StripTest {

    public static void main(String[] args) {
        String str = "   hello Huê ";
        System.out.println("_" + str.strip() + "_");

        Thread thread = new Thread(() -> {
            System.out.println("thread is running");
        });

        thread.start();
    }
}

