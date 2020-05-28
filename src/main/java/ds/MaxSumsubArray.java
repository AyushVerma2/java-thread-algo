package ds;

/**
 * Kadane Algo
 */
public class MaxSumsubArray {
    public static void main(String[] args) {


        int data[]= { -2,-3,-6,-1,10,6,3,-100,-34};
        findMaxSubArray(data);


    }


    static void findMaxSubArray(int a[]){

        int max_so_far=a[0];
        int max_end_here=0;
        int start=0,end=0,s=0;


        for(int i=0;i<a.length;i++){
            max_end_here=max_end_here+a[i];
            if(max_so_far<max_end_here){
                max_so_far=max_end_here;
                start=s;
                end=i;

            }
            if(max_end_here<0){
                max_end_here=0;
                s=i+1;

            }

        }

        System.out.println("Start index"+ start);
        System.out.println("End index"+ end);
    }
}
