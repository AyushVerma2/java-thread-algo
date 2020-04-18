package Threads;

import java.util.concurrent.RecursiveTask;

/**
 * Example for for join pool
 * it is same as executor server im one each thread divide the task in sub=task,
 * do the compute and join the results.
 * each thread maind there own DeQue , which is used to store the
 * sub-task and if one thread DEQue is empty,it will pull the task
 * from other thread from rare end(work stealing_
 */
public class Fibonacci extends RecursiveTask<Integer> {
    int n;
    Fibonacci(int n){
        this.n=n;
    }
    @Override
    protected Integer compute() {
        if(n<=1){
            return n;

        }
        Fibonacci f1 = new Fibonacci(n-1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n-2);
        f2.fork();
        return f1.join()+f2.join();

    }

    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci(10);
        System.out.println(fibonacci.compute());
    }
}

