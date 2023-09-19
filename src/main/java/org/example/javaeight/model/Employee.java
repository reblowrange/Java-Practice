package org.example.javaeight.model;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class Employee {
    private final Long id;
    private final String name;
    private final Long Salary;
    private final EmployeDept employeeDept;
    private Set<Account> accounts;

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

