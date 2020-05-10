package array;

import java.util.Arrays;

public class Fibbnocci {
    public static void main(String[] args) {
        System.out.println(fibnocci(10));
        System.out.println(fib(10));
        System.out.println(fib1(10));
    }

    /**
     * NON Memoization:
     * issue: for sam number sasy fib(3) is calcumated many times
     * in the recusrion tree
     *
     * @param num
     * @return
     */

    static int fibnocci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibnocci(num - 1) + fibnocci(num - 2);
    }

    /**
     * With Memoization:
     * issue: for sam number sasy fib(3) is calcumated many times
     * in the recusrion tree
     *
     * @param n
     * @return
     */

    static int fib(int n) {
        int lookup[] = new int[100];
        Arrays.fill(lookup,-1);
        if (lookup[n] == -1) {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }

    /**
     * Iterative methods
     * @param n
     * @return
     */
    static int fib1(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }
//    static int fib(int n){
//        int memo[] = new int[200];
//        Arrays.fill(memo,-1);
//        if (n ==0){
//            return 0;
//        }
//        if (n ==1){
//            return 1;
//        }
//        if(memo[n]<1){
//            memo[n]=n;
//        }
//        else{
//            memo[n] = fib(n-1)+fib(n-2);
//
//        }
//
//        return memo[n];
//    }
}
