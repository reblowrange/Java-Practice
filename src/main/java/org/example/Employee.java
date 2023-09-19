package org.example;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String name;
    private Long Salary;
    private EmployeDept employeeDept;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        return employeeDept == employee.employeeDept;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + employeeDept.hashCode();
        return result;
    }
}

enum EmployeDept {
    FINANCE,
    MARKETING,
    HUMAN_RESOURCE,
    DEVELOPMENT
}