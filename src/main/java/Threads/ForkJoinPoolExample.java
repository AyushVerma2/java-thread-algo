package Threads;

import java.util.concurrent.RecursiveTask;

/**
 * Example for for join pool
 * it is same as executor server im one each thread divide the task in sub=task,
 * do the compute and join the results.
 * each thread maintain there own DeQue , which is used to store the
 * sub-task and if one thread DEQue is empty,it will pull the task
 * from other thread from rare end(work stealing_
 */
public class ForkJoinPoolExample extends RecursiveTask<Integer> {
    int n;

    ForkJoinPoolExample(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ForkJoinPoolExample fibonacci = new ForkJoinPoolExample(10);
        System.out.println(fibonacci.compute());
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;

        }
        ForkJoinPoolExample f1 = new ForkJoinPoolExample(n - 1);
        f1.fork();
        ForkJoinPoolExample f2 = new ForkJoinPoolExample(n - 2);
        f2.fork();
        return f1.join() + f2.join();

    }
}

