package array;

public class BinarySearch {
    public static void main(String[] args) {

        int[] data = {2, 4, 5, 6, 77, 88};
        boolean isPresent = find(data, 6);
        boolean isPresentR = findRecursive(data, 0, data.length, 6);
        System.out.println("Is number present > " + isPresent);
        System.out.println("Is number present REC > " + isPresentR);
    }

    private static boolean find(int[] data, int i) {
        int end = data.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == i) {
                return true;
            }
            if (i > data[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return false ;
    }

    private static boolean findRecursive(int[] data, int start, int end,
                                         int item) {

        System.out.println(data[start]);
        if (start >= end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (item == data[mid]) {
            return true;
        }
        return item <= data[mid] ? findRecursive(data, start, mid - 1, item) :
                findRecursive(data, mid + 1, end, item);

    }
}
