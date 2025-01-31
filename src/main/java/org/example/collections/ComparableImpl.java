package org.example.collections;

import org.example.collections.model.Emp;
import org.example.collections.model.EmpComparatorByName;
import org.example.collections.model.EmpCompareById;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableImpl {
    public static void main(String[] a) {
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp(4, "swapnil", 30));
        emps.add(new Emp(7, "girish", 32));
        emps.add(new Emp(1, "rajat", 28));
        emps.add(new Emp(3, "amit", 31));

        Collections.sort(emps);
        /*
        System.out.println("ComparableI---"+ emps);
        Collections.sort(emps, new EmpComparatorByName());
        */

        Comparator<Emp> comparator = Comparator.comparing(Emp::getId).thenComparing(Emp::getName).reversed();
        /*
        Collections.sort(emps, comparator);
        System.out.println("Comparator-By- Id and Name--"+emps);
        */
        emps.stream().sorted(comparator).forEach(System.out::println);
//        emps.stream().sorted(new EmpCompareById()).forEach(System.out::println);
    }
}
