package Threads;

import java.util.concurrent.*;

/**
 * A handler for tasks that cannot be executed by a {@link ThreadPoolExecutor}.
 */
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
    /**
     * Method that may be invoked by a {@link ThreadPoolExecutor} when
     * {@link ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     *
     * <p>In the absence of other alternatives, the method may throw
     * an unchecked {@link RejectedExecutionException}, which will be
     * propagated to the caller of {@code execute}.
     *
     * @param r        the runnable task requested to be executed
     * @param executor the executor attempting to execute this task
     * @throws RejectedExecutionException if there is no remedy
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        // do logging..
        System.out.println("what need to eb done");
    }
}