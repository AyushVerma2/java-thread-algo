package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService {
    public static void main(String a[]) {

        oldway(12);
        testExecutor();
        System.out.println("Current thread is " + Thread.currentThread().getName());
    }

    private static void oldway(int i2) {
        for (int i = 0; i < i2; i++) {

            new Thread(() -> System.out.println("Task #2 is running" + Thread.currentThread().getName())).start();
        }
    }


    private static void testExecutor() {

// so mac thread will be 10 . even it perfrom 100 task submitted
        // it used blocking Queue as it is thread safge,, all thread will try to fethc the
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("Task in Executor is running" + Thread.currentThread().getName()));
        }
    }

    /**
     * Task like find the hash or cryptographic fucntion
     */
    private static void testExecutorForCPUintensive() {

        int numberOfCoreprocessor = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCoreprocessor);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("CPU intesnive task is  running" + Thread.currentThread().getName()));
        }
    }

    /**
     * Task to read from dB or File or network
     * too many thread is mermory consumption
     */
    private static void testExecutorForIOintensive() {

        // may be all thread is wating ,so we can more thread then core..
        int numberOfthread = 50;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfthread);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println("IO intesnive task is  running" + Thread.currentThread().getName()));
        }
    }


}
