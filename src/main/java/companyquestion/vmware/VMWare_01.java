package companyquestion.vmware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Problem statement: Portfolio balances
 * https://docs.google.com/document/d/151N6_JqZ2VmewBQ4VTs2aTNr2xKKWSTnyVHCyYCwe6Q/edit
 */
public class VMWare_01 {

    public static void main(String[] a) {

        List<Integer> intLst1 = new ArrayList<>();
        List<Integer> intLst2 = new ArrayList<>();
        List<Integer> intLst3 = new ArrayList<>();
        intLst1.add(1);
        intLst1.add(2);
        intLst1.add(10);

        intLst2.add(2);
        intLst2.add(4);
        intLst2.add(5);

        intLst3.add(3);
        intLst3.add(5);
        intLst3.add(12);

        List<List<Integer>> input = new ArrayList<>();
        input.add(intLst1);
        input.add(intLst2);
        input.add(intLst3);


        long start = System.currentTimeMillis();
        //long max =maxValue(3,input);
        long max = getListInput(5, input);
        long end = System.currentTimeMillis();
        System.out.println("MAX " + max + " TIME Start : " + start + " TIME END : " + end);


    }

    static long getListInput(int n, List<List<Integer>> input) {

        long[] arr = new long[n];
        long max = 0;

        for (int i = 0; i < input.size(); i++) {
            List<Integer> data = input.get(i);
            for (int j = data.get(0) - 1; j < data.get(1); j++) {
                arr[j] = arr[j] + data.get(2);
                max = max < arr[j] ? arr[j] : max;
            }
        }
        return max;
    }


    public static long maxValue(int n, List<List<Integer>> rounds) {
        long[] ar = new long[n];
        rounds.stream().forEach(round -> {
            IntStream.range(round.get(0), round.get(1)).forEach(index -> {
                ar[index - 1] = ar[index - 1] + round.get(2);
            });
        });

        long result = 0;
        for (long val : ar) {
            if (val > result) result = val;
        }
        return result;
    }

}
