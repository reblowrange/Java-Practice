package org.example.threads.runners;

import org.example.threads.model.EntityOne;

public class EntityModifer extends Thread {
    EntityOne entityOne;

    public EntityModifer(EntityOne entityOne) {
        this.entityOne = entityOne;
    }

    @Override
    public void run() {
//        System.out.println("EntityModifer " + this.getName());
            try {
                for (int i = 1; i <= 10; i++) {
                    this.entityOne.decrease();
                    this.entityOne.addValue(i);
                    Thread.sleep(100);
                    System.out.println(this.entityOne.getValue() + "  "+this.getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
