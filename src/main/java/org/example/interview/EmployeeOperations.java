package org.example.interview;

import org.example.javaeight.EmployeeStreamOperations;
import org.example.javaeight.model.EmployeDept;
import org.example.javaeight.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EmployeeOperations {
    public static void main(String[] a){
        List<Employee> employees = EmployeeStreamOperations.getEmployees();
        employees.stream().forEach(System.out::println);


//        1.	Collect all employee’s names in one list, who have salary >5000.
        System.out.println("1.\tCollect all employee’s names in one list, who have salary >16000.");
        employees.stream().filter(x->x.getSalary()>16000).forEach(System.out::println);
//        2.	Find employee’s name who has min salary.
        System.out.println("2.\tFind employee’s name who has min salary.");
        employees.stream().min((x,y)->Long.compare(x.getSalary(),y.getSalary())).ifPresent(System.out::println);
//        3.	Group by all employees object based on dept.
        System.out.println("3.\tGroup by all employees object based on dept.");
         Map<EmployeDept, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getEmployeeDept));
         collect.keySet().stream().forEach(x -> System.out.println(x +": " + collect.get(x)));
//        4.	Sort the list based on salary.
//        5.	Find out all employee’s mobile numbers in a single List.
         TreeSet<Long> allEmployeeMob = employees.stream().flatMap(x->x.getMobileNo().stream()).collect(Collectors.toCollection(TreeSet::new));
         System.out.println("5.\t All Mobile Numbers \n" + allEmployeeMob);
//        6.	Find all employee's salary sum amount.
         double totalSal = employees.stream().mapToDouble(Employee::getSalary).sum();
         System.out.println("4.\t Total Salary " + totalSal);
    }
}
