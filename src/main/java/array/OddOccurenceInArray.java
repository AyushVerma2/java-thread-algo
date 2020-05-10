package array;

public class OddOccurenceInArray {
    public static void main(String[] args) {
        int[] solution = {2, 3, 4, 4, 3, 1, 1};
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
