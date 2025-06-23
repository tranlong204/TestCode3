package thread.s3.Join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 343355L, 355L, 244L, 314L, 23L, 415L);

        List<FactorialThread> factorialThreads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            factorialThreads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread: factorialThreads) {
            thread.start();
        }

        for (Thread thread: factorialThreads) {
                thread.join(2000);
        }
        for (int i = 0; i < factorialThreads.size(); i++) {
            FactorialThread factorialThread = factorialThreads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress.");
            }
        }
    }

    public static class FactorialThread extends Thread {

        private Long inputNumber;
        private boolean isFinished = false;
        private BigInteger result = BigInteger.ZERO;

        public FactorialThread(Long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorialCal(inputNumber);
            isFinished = true;
        }

        private BigInteger factorialCal(Long inputNumber) {
            BigInteger result = BigInteger.ONE;
            for (long i = 2; i <= inputNumber; ++i) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }


        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }

    }
}
