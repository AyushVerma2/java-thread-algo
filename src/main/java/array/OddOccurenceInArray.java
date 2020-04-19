package array;

public class OddOccurenceInArray {
    public static void main(String[] args) {
        int[] solution = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(solution));
    }

    static int solution(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i];

        }
        return res;
    }
}
