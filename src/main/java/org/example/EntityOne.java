package org.example;

import java.util.ArrayList;

public class EntityOne {
    private boolean flag;
    private Object object;

    private int value;

    private ArrayList<Integer> values= new ArrayList<>();

    EntityOne(boolean flag) {
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void increase() {
        this.value++;
    }

    public void decrease() {
        this.value--;
    }

    public synchronized void addValue(Integer val) {
        this.values.add(val);
    }

    public synchronized ArrayList<Integer> getValues() {
        return this.values;
    }
    public int getValue() {
        return value;
    }
}
