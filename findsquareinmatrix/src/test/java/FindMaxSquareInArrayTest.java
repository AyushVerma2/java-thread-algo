import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class FindMaxSquareInArrayTest {

    @Test
    public void testValidInput() {

        FindMaxSquareInArray findMaxSquareInArray
                = new FindMaxSquareInArray();
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

        assertEquals(findMaxSquareInArray.largestSubmatrix(input), 9);

    }

    @Test
    public void testInValidInput() {

        FindMaxSquareInArray findMaxSquareInArray
                = new FindMaxSquareInArray();

        Assertions.assertThrows(NullPointerException.class, () -> {
            findMaxSquareInArray.largestSubmatrix(null);
        });


    }

    @Test
    public void testInValidInput_1() {

        FindMaxSquareInArray findMaxSquareInArray
                = new FindMaxSquareInArray();
        int[][] a = {{}};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            findMaxSquareInArray.largestSubmatrix(a);
        });


    }


}
