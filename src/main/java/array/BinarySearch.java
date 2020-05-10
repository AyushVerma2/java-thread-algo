package array;

public class BinarySearch {
    public static void main(String[] args) {

        int [] data ={2,4,5,6,77,88};
        boolean isPresent = find(data,6);
        System.out.println("Is number present > "+isPresent);
    }

    private static boolean find(int[] data, int i) {
        int end=data.length-1;
        int start=0;

        while (start<=end){
            int mid = (start + end)/2;
            if(data[mid]== i){
                return true;
            }
            if(i>data[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;

            }
        }
        return false;
    }
}
