package array;

public class PrintPair {
    public static void main(String[] args) {

     int input[]= {2, 4, 3, 5, 6, -2, 4, 7, 8, 9} ;
     int sum=7;
        printPairs(input,sum);


    }
    public static void printPairs ( int[] array, int sum){
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if ((first + second) == sum) {
                    System.out.println("Result : "+ first+ "   "+second);
                }
            }
        }
    }
}
