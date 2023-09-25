package org.example.funtru.model;

import java.util.Comparator;

public class EmpComparatorByName implements Comparator<Emp> {
    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
