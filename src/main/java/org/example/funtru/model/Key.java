package org.example.funtru.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Key {
    private final String key;

    @Override
    public boolean equals(Object o) {
        return key.equals((String)o);
    }

    @Override
    public int hashCode() {
        return (int) key.charAt(0);
    }
}
