package org.example;

public class EntityWriter extends Thread {
    EntityOne entityOne;

    EntityWriter(EntityOne entityOne) {
        this.entityOne = entityOne;
    }

    @Override
    public void run() {
//        System.out.println("EntityWriter " + this.getName());

        try {
            for (int i = 11; i <= 20; i++) {
                this.entityOne.increase();
                this.entityOne.addValue(i);
                Thread.sleep(100);
                System.out.println(this.entityOne.getValue() + "  "+this.getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.entityOne.setFlag(false);
    }
}
