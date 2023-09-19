package org.example;

public class ThreadSharedResource {
    public static void main(String[] args) throws InterruptedException {
        EntityOne entity = new EntityOne(true);

        Thread thread0 = new EntityModifer(entity);
        Thread thread1 = new EntityWriter(entity);
        Thread readerThread = new Thread(() -> {
            while (entity.isFlag()) {
                try {
                    System.out.println("Result: " + entity.getValues());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread0.start();
        thread1.start();
        readerThread.start();

//        thread0.join();
        thread1.join();
        readerThread.join();
//        Thread.sleep(1500);
//        Thread.currentThread().join(1500);
    }
}
