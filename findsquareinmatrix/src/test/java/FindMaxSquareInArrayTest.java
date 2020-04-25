import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class FindMaxSquareInArrayTest {

    @Test
    public void testValidInput() {

        FindMaxSquareInArray findMaxSquareInArray
                = new FindMaxSquareInArray();


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
