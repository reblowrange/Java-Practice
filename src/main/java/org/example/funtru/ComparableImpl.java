package org.example.funtru;

import org.example.funtru.model.Emp;
import org.example.funtru.model.EmpComparatorByName;
import org.example.funtru.model.EmpCompareById;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableImpl {
    public static void main(String[] a) {
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp(4, "swapnil", 30));
        emps.add(new Emp(7, "girish", 32));
        emps.add(new Emp(1, "rajat", 28));
        emps.add(new Emp(3, "amit", 31));

        Collections.sort(emps);
        System.out.println("ComparableI---"+ emps);
        Collections.sort(emps, new EmpComparatorByName());
        System.out.println("Comparator-By-Name--"+emps);

        emps.stream().sorted(new EmpCompareById()).forEach(System.out::println);
    }
}
