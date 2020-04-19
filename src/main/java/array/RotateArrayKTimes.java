package array;

import java.util.Arrays;

public class RotateArrayKTimes {

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        System.out.println(Arrays.toString(solution(A, K)));

    }

    public static int[] solution(int[] A, int K) {

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {

            int newIdex = i + K < A.length ? i + K : (i + K) % A.length;
            result[newIdex] = A[i];
        }
        return result;
    }
}
