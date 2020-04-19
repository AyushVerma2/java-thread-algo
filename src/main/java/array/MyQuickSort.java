package array;

import java.util.Arrays;

public class MyQuickSort {
    public static void main(String[] args) {

        int[] i = {6, 5, 3, 1, 8, 7, 2, 4};

        QuickSort myQuickSort
                = new QuickSort();

        System.out.println(Arrays.toString(i));
        myQuickSort.sort(i);
        System.out.println(Arrays.toString(i));

    }
}


class QuickSort {

    int[] input;
    int lenght;


    void quicksort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = input[low + (high - low) / 2];


        while (i <= j) {

            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);

        }
    }

    void sort(int[] input) {


        if (input == null || input.length == 0) {
            return;
        }
        this.lenght = input.length;
        this.input = input;

        quicksort(0, lenght - 1);


    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}


class QuickSort1 {

    private int[] input;
    private int length;

    public void sort(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length - 1);
    }

    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        int pivot = input[low + (high - low) / 2];

        // Divide into two arrays
        while (i <= j) {
            /**
             * As shown in above image, In each iteration, we will identify a
             * number from left side which is greater then the pivot value, and
             * a number from right side which is less then the pivot value. Once
             * search is complete, we can swap both numbers.
             */
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }

        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
