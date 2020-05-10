package ds;

import java.util.Arrays;

public class DynamicProg {
    static int arr[][] = new int[8][8];

    public static void main(String[] args) {
//        numOfPath();
//        print();
        initialize();
        setBomb();
        System.out.println(numberOfPaths(8,8));
    }

    public static void print() {
        // Loop through all rows
        for (int[] row : arr) {
            System.out.println();
            // Loop through all columns of current row
            for (int x : row)
                System.out.print(x + " ");
        }
        System.out.println();
    }

    static int numOfPath() {

        initialize();

        print();
        System.out.println("**********************");
        setBomb();
        print();
        System.out.println("**********************");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                int rowD = getTopValue(i - 1, j);
                int colD = getSideValue(i, j - 1);
                arr[i][j] = rowD + colD;


            }
        }


        return -1;
    }

    private static void initialize() {
        int row = arr.length;
        int colum = arr[0].length;

        for (int i = 0; i < row; i++)
            Arrays.fill(arr[i], 0);
    }

    private static void setBomb() {
        arr[1][2] = -1;
        arr[1][6] = -1;
        arr[2][4] = -1;
        arr[3][0] = -1;
        arr[3][2] = -1;
        arr[3][5] = -1;
        arr[4][2] = -1;
        arr[5][3] = -1;
        arr[5][4] = -1;
        arr[5][6] = -1;
        arr[6][1] = -1;
        arr[6][5] = -1;
    }

    static int getTopValue(int row, int col) {
        if (row <= 0 || arr[row][col] == -1) {
            return 0;
        }

        return arr[row][col] == 0 ? 1 : arr[row][col];
    }

    static int getSideValue(int row, int col) {
        if (col <= 0 || arr[row][col] == -1) {
            return 0;
        }
        return arr[row][col] == 0 ? 1 : arr[row][col];
    }

    static int numberOfPaths(int m, int n)
    {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }
}


