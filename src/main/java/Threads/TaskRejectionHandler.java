package Threads;

import java.util.concurrent.*;

public class TaskRejectionHandler {

    public static void main(String[] args) {

        ExecutorService ses = new ThreadPoolExecutor(10, 20, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(300),
                new CustomeRejectionHandler());

        // to shutdown
        ses.shutdown(); // it will initiate only

    }


}

class CustomeRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        // do logging..
        System.out.println("what need to eb done");
    }
}