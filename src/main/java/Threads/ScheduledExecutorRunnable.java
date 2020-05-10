package Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRunnable {

    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);


        task1();

        //run this task after 5 seconds, nonblock for task3
        ses.schedule(() -> System.out.println("This is scheduled task"), 5,
                TimeUnit.SECONDS);

        task3();

        ses.shutdown();

    }

    public static void task1() {
        System.out.println("Running task1...");
    }

    public static void task3() {
        System.out.println("Running task3...");
    }


}
