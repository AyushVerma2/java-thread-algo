package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeList {
    public static void main(String[] args) {


        List<Employee> allEmployee = new ArrayList<>();

        allEmployee.add(new Employee("AA", 1000));
        allEmployee.add(new Employee("BB", 2000));
        allEmployee.add(new Employee("CC", 3000));
        allEmployee.add(new Employee("DD", 4000));
        allEmployee.add(new Employee("EE", 5000));
        allEmployee.add(new Employee("FF", 6000));
        allEmployee.add(new Employee("GG", 7000));


        allEmployee.stream().forEach(w -> System.out.println(w));

        // filter
        System.out.println("Filtering based on salary");
        allEmployee.stream()
                .filter(e -> e.getSalary() < 5000)
                .filter(e -> e.getSalary() > 2000)
                .forEach(w -> System.out.println(w.getName()));


        List<String> nameLst = allEmployee.stream()
                .filter(e -> e.getSalary() < 5000)
                .filter(e -> e.getSalary() > 2000)
                .map(b -> b.getName()).collect(Collectors.toList());

        List<Integer> salaryLst = allEmployee.stream()
                .filter(e -> e.getSalary() < 5000)
                .filter(e -> e.getSalary() > 2000)
                .map(b -> b.getSalary()).collect(Collectors.toList());

        int a[] = {2, 4, 6, 88, 9, 8, 4, 6, 3};
        int sum = IntStream.of(a).filter(e -> e > 6)
                .sum();
        System.out.println("Sum :: " + sum);

        IntStream.of(a)
                .distinct().forEach(c -> System.out.print(c + " "));
    }


}

//@NoArgsConstructor
//@AllArgsConstructor
//class Employee {
//    String name;
//    int salary;
//
//    Employee(String name, int salary) {
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//
//
//}