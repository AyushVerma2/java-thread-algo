package array;

public class MaxSquare {


    static int largestSubmatrix(int[][] a) {
        int Row = 4, Col = 5;
        int[][] dp = new int[Row][Col];
        int result = 0;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                // If elements is at top
                // row or first column,
                // it wont form a square
                // matrix's bottom-right
                if (i == 0 || j == 0)
                    dp[i][j] = 1;

                else {
                    // Check if adjacent
                    // elements are equal
                    if (a[i][j] == a[i - 1][j] &&
                            a[i][j] == a[i][j - 1] &&
                            a[i][j] == a[i - 1][j - 1]) {
                        dp[i][j] = (dp[i - 1][j] > dp[i][j - 1] &&
                                dp[i - 1][j] > dp[i - 1][j - 1] + 1) ?
                                dp[i - 1][j] :
                                (dp[i][j - 1] > dp[i - 1][j] &&
                                        dp[i][j - 1] > dp[i - 1][j - 1] + 1) ?
                                        dp[i][j - 1] :
                                        dp[i - 1][j - 1] + 1;
                    }

                    // If not equal, then it
                    // will form a 1x1 submatrix
                    else dp[i][j] = 1;
                }

                // Update result at each (i,j)
                result = result > dp[i][j] ?
                        result : dp[i][j];
            }
        }
        // returning the Area,
        return result * result;
    }

    public static void main(String[] args) {
        int[][] a = {{2, 2, 3, 3, 4, 4},
                {5, 5, 7, 7, 7, 4},
                {1, 2, 7, 7, 7, 4},
                {4, 4, 7, 7, 7, 4},
                {5, 5, 5, 1, 2, 7},
                {8, 7, 9, 4, 4, 4}};

        int[][] input = {{0, 3, 3, 3, 0},
                {2, 3, 3, 3, 3},
                {1, 3, 3, 3, 2},
                {0, 0, 2, 1, 0}};

        System.out.println(largestSubmatrix(input));

    }
}

