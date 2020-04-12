package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem statement: Portfolio balances
 * https://docs.google.com/document/d/151N6_JqZ2VmewBQ4VTs2aTNr2xKKWSTnyVHCyYCwe6Q/edit
 *
 */
public class VMWare_01 {

    public static void main(String a[]) {

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

        int[] result = getListInput(input);
        System.out.println(Arrays.toString(result));


    }

    static int[] getListInput(List<List<Integer>> input) {

        int arr[] = new int[]{0, 0, 0, 0, 0};

        for (int i = 0; i < input.size(); i++) {
            arr = updateData(arr, input.get(i).get(0), input.get(i).get(1),
                    input.get(i).get(2));

        }
        return arr;
    }

    static int[] updateData(int[] arr, int start, int end, int data) {
        for (int i = start - 1; i < end; i++) {
            arr[i] = arr[i] + data;
        }
        return arr;

    }

}
