package stream;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Employee {
    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    private String name;
    private Integer salary;


}
