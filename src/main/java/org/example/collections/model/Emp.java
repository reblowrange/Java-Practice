package org.example.collections.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class Emp implements Comparable<Emp>{
    private final int id;
    private final String name;
    private final Integer age;

    @Override
    public int compareTo(Emp o) {
        return Integer.compare(this.age,o.age);
    }
}
