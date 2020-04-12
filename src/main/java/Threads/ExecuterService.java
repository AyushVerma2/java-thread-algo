package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService {
    public static void main(String[] a) {

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

// so max thread will be 10 . even it perform 100 task submitted
        // it used blocking Queue as it is thread safe,, all thread will try
        // to fetch the
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> System.out.println("Task in Executor is running" + Thread.currentThread().getName()));
        }
    }

    /**
     * Task like find the hash or cryptographic function
     * if task is pur bond then no o thread shud be eaqula to no of cores
     * if task has lots io bond then no of thread can be more that cores.
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
