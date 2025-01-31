package org.example;

import org.example.javaeight.EmployeeStreamOperations;
import org.example.javaeight.model.EmployeDept;
import org.example.javaeight.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeOne {
    public static void main(String[] a) {
   /*     *//* stream api program to show the department and list of employees like this HashMap<String, List<Employees>> *//*
        List<Employee> employees = EmployeeStreamOperations.getEmployees();
        Map<EmployeDept, Long> output = employees.stream().collect(Collectors.groupingBy(Employee::getEmployeeDept, Collectors.counting()));
        for(Map.Entry e:output.entrySet()) {
           System.out.println(e.getKey() +"-"+ e.getValue());
        }*/


        /*
        Rotate an Image 90 Degree Counterclockwise
        *   Input:
             1    2    3   4
             5   6    7   8
             9  10   11  12
             13  14  15  16
            Output:
             4  8  12  16
             3  7  11   15
             2  6  10  14
             1   5  9   13
        * */
        int number = 1, n=4;
        int[][] array = new int[n][n];

        // Fill the array with natural numbers
        System.out.println("Input: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = number++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.println("Rotate an Image 90 Degree Counterclockwise");
        System.out.println("Output: \n");
        // Print the array
        /*
            03,13,23,33
            02,12,22,32
            01,11,21,31
        */
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[j][i] + "\t");
            }
            System.out.println();
        }

        System.out.println("Interchange elements of first and last rows in matrix");
        System.out.println("Output: \n");
        /* 00 -> 30, 01 -> 31, 02 -> 32*/
        int[][] cloned = array.clone();
        for(int i=0;i<n;i++) {
            int temp = cloned[0][i];
            cloned[0][i] = cloned[n-1][i];
            cloned[n-1][i] = temp;
        }
        printArray(cloned);
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
//                array[i][j] = number++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
