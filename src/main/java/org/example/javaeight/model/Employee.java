package org.example.javaeight.model;

import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private final Long id;
    private final String name;
    private final Long Salary;
    private final EmployeDept employeeDept;
    private Set<Account> accounts;
    private final List<Long> mobileNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + employeeDept.hashCode();
        return result;
    }
}

