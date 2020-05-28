package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream internally creae cop
 *
 * Stream :: 1. Create, proceess, consume, final termila operation
 *
 */
public class Example01 {
    public static void main(String[] args) {
        //primitiveOperations();
        UserObjectOperations();

    }

    private static void UserObjectOperations() {
        List<Employee> allEmp = new ArrayList<>();
        allEmp.add(new Employee("AAA",100));
        allEmp.add(new Employee("BBB",200));
        allEmp.add(new Employee("CCC",50));
        allEmp.add(new Employee("DDD",700));

        allEmp.stream()
                .distinct()
                .filter(s -> s.getSalary()>70)
                .map(Employee::getName)
               // .collect(Collectors.toList())
                .forEach(System.out::println);

        // join
        String empAll =allEmp.stream().map(e -> e.getName())
                .collect(Collectors.joining(","));

        // groupby
        Map<String,List<Employee>> mapEmp =allEmp.stream()
                .distinct()
                .filter(s -> s.getSalary()>70)
                .collect(Collectors.groupingBy(e->e.getName()));

    }

    private static void primitiveOperations() {
        // find the max in array
        int data[] = {2, 44, 5, 7, 88, 9, 234};

        int max = IntStream.of(data).max().getAsInt();
        System.out.println("MAx is " + max);
        IntSummaryStatistics intSummaryStatistics =
                IntStream.of(data).summaryStatistics();
        System.out.println("Max: " + intSummaryStatistics.getMax());
        System.out.println("Average : " + intSummaryStatistics.getAverage());
        System.out.println("Sum : " + intSummaryStatistics.getSum());
        System.out.println("Count : " + intSummaryStatistics.getCount());


        System.out.println("find top three distinct : ");
        // find top three distinct
        IntStream.of(data)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        // reverse and sort
        Integer data02[] = {2, 44, 5, 7, 88, 9, 234};
        Arrays.sort(data02, Collections.reverseOrder());
        //Arrays.sort(input, (a, b) -> b - a); // reverse order


        for (int i = 0; i < data02.length; i++)
            System.out.println(data02[i]);


        IntStream.of(data).allMatch(n -> n%2==0);
        // IntStream.of(data).anyMatch(n -> n%2==0);
    }


}
