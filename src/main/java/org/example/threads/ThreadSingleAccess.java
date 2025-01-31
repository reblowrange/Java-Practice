package org.example.threads;

public class ThreadSingleAccess {
    volatile static int token = 1;

    public static void main(String a[]) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ".. Assigned Token " + token);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            token++;
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ".. Assigned Token " + token);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            token++;
        });

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ".. Assigned Token " + token);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            token++;
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
