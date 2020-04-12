package general;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem statement:Feature Products
 * https://docs.google.com/document/d/151N6_JqZ2VmewBQ4VTs2aTNr2xKKWSTnyVHCyYCwe6Q/edit
 *
 */
public class VMware_02 {

    public static void main(String a[]) {

        List<String> prods = Arrays.asList("aaa", "nnn", "ttt", "aaa", "fff", "nnn",
                "fafda", "ytt","nnn","nnn","aaa","aaa","nnn");
        System.out.println(featuredProdue(prods));
    }

    public static String featuredProdue(List<String> products) {

        Map<String, Integer> counts = products.parallelStream().
                collect(Collectors.toConcurrentMap(
                        w -> w, w -> 1, Integer::sum));

        return Collections.max(counts.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();

//        Map<String, Integer> res = new TreeMap();
//                res.putAll(counts);
//
//        return Collections.max(res.entrySet(),
//                Comparator.comparingInt(Map.Entry::getValue)).getKey();

        //return ((TreeMap<String, Integer>) res).firstEntry().getKey();

    }
}
