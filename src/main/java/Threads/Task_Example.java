package Threads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * this is an example where user has to fidn the best price from the 3 hotel API and give the result
 */
public class Task_Example {

    public static void main(String a[]) throws InterruptedException, TimeoutException, ExecutionException {

        Set<Integer> allPrices = getProdcutPrice("1234", "hotelURL");
        allPrices.forEach(System.out::println);
    }

    public static Set<Integer> getProdcutPrice(String productID, String url) throws InterruptedException, TimeoutException, ExecutionException {
        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());
        byExecuterService(url, productID, price);
        byCountDownLatch(url, productID, price);
        byCompletableFuture(url, productID, price);
        return price;
    }

    /**
     * time out of mail is fixed..
     *
     * @throws InterruptedException
     */
    private static void byExecuterService(String url, String product_id, Set<Integer> price) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 3; i++) {
            executorService.submit(new Task("hotelUrl", product_id, price));
        }

        Thread.sleep(3000);// wait for 3 sec
    }

    /**
     * Using countdown latch to hold the count of the task.
     * can you patch also instead of countdown latch
     *
     * @throws InterruptedException
     */
    private static void byCountDownLatch(String url, String product_id, Set<Integer> price) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Task("hotelUrl", product_id, price), countDownLatch);
        }

        countDownLatch.await();
        //countDownLatch.await(3, TimeUnit.SECONDS);
    }

    private static void byCompletableFuture(String url, String product_id, Set<Integer> price) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture task_1 = CompletableFuture.runAsync(new Task(url, product_id, price));
        CompletableFuture task_2 = CompletableFuture.runAsync(new Task(url, product_id, price));
        CompletableFuture task_3 = CompletableFuture.runAsync(new Task(url, product_id, price));
        CompletableFuture allTask = CompletableFuture.allOf(task_1, task_2, task_3);


        //allTask.get();
        allTask.get(3, TimeUnit.SECONDS);
    }
}


class Task implements Runnable {

    private Set<Integer> price;
    private String url;
    private String product_id;
    public Task(String url, String product_id, Set<Integer> price) {
        this.price = price;
        this.url = url;
        this.product_id = product_id;
    }

    @Override
    public void run() {
        // call API to feth the price

        //fethcPrice(url);
    }
}