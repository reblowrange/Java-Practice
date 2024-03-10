package org.example.javaeight;

import org.example.javaeight.model.Account;
import org.example.javaeight.model.Bank;
import org.example.javaeight.model.EmployeDept;
import org.example.javaeight.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    private static List<Integer> arr = Arrays.asList(4, 6, 1, 3, 9, 0, 2, 6, 5, 7);

    private static List<Employee> employees;
    private static long leftLimit = 15000L;
    private static long rightLimit = 20000L;
    private static int nameStringLength = 1;

    static {
        // Generate Employee data
        Random random = new Random();
        employees = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            long salary = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            List<Long> mobileNos = Arrays.asList(generateRandomMobileNumber(), generateRandomMobileNumber());
            employees.add(new Employee(
                    Long.valueOf(i + 1),
                    getRandomString(),
                    salary,
                    getRandomEnum(EmployeDept.class, random),
                    mobileNos));
        }
    }

    public static void main(String[] args) {
        employeeStreamOperations(employees);
    }

    public static List<Employee> getEmployees(){
        return employees;
    }
    // Method to get a random enum value
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass, Random random) {
        T[] enumValues = enumClass.getEnumConstants();
        int randomIndex = random.nextInt(enumValues.length);
        return enumValues[randomIndex];
    }

    private static String getRandomString() {
        Random random = new Random();
        int leftLimit = 65; // letter 'A'
        int rightLimit = 70; // letter 'F'
        return random.ints(leftLimit, rightLimit + 1)
                .limit(nameStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static long generateRandomMobileNumber() {
        // Initialize a Random object
        Random random = new Random();

        // Generate a random 10-digit mobile number
        long minMobileNumber = 1000000000L; // 10 digits starting from 1
        long maxMobileNumber = 9999999999L; // 10 digits with all 9s
        long range = maxMobileNumber - minMobileNumber + 1;
        long randomMobileNumber = (long) (random.nextFloat() * range) + minMobileNumber;

        return randomMobileNumber;
    }
    private static Integer findMin(List<Integer> input) {
        Integer result = input.stream().min((x, y) -> x - y).get();
        System.out.println(input + " Min: " + result);
        return result;
    }


    private static void employeeStreamOperations(List<Employee> input) {

        // Sorted
        List<Employee> sorted = input.stream().sorted((x, y) -> Long.compare(y.getSalary(), x.getSalary())).collect(Collectors.toList());
        sorted.forEach(System.out::println);

        input.stream().sorted((x,y)->Long.compare(x.getSalary(),y.getSalary())).forEach(System.out::println);


        // Find any element that starts with the letter 'c'
        sorted.stream()
                .filter(s -> s.getName().startsWith("C"))
                .findAny().ifPresent(name -> System.out.println("findAny() - Starts with 'C':" + name));

        // Find First
        sorted.stream()
                .filter(s -> s.getName().startsWith("D"))
                .findFirst().ifPresent(name -> System.out.println("findFirst() - Starts with 'D':" + name));

        // Distinct
        System.out.println("--- Distinct ---\n");
        System.out.println(employees.toString());
        employees.stream().distinct().forEach(System.out::println);

        // Reduce
        Optional<Employee> highSalary = employees.stream().reduce((x, y) -> x.getSalary() > y.getSalary() ? x : y);
        System.out.println(" High Salary: " + highSalary);

        // Min
        Employee min = input.stream().min((x, y) -> Long.compare(x.getSalary(), y.getSalary())).get();
        // Max
        Employee max = input.stream().max((x, y) -> Long.compare(x.getSalary(), y.getSalary())).get();

        System.out.println(" Min: " + min);
        System.out.println(" Max: " + max);

        // Employee Third-highest salary person
        sorted.stream().skip(2).findFirst().ifPresent(x -> System.out.println("\n 3rd Highest Salary::" + x));

        /* Employee adding account details with map
         * @class EmployeeAccount
         */

        employees.stream().map(StreamAPI::addAccounts).forEach(System.out::println);
    }

    private static Employee addAccounts(Employee emp) {
        Random rd = new Random();
        Set<Account> accs = new HashSet<>();
        int i1 = (int) (1 + (long) (Math.random() * 3));
        for (int i = 0; i < i1; i++) {
            long accNum = 1001 + (long) (Math.random() * 1000);
            accs.add(new Account((int) accNum, getRandomEnum(Bank.class, rd)));
        }

        emp.setAccounts(accs);
        return emp;
    }


}
