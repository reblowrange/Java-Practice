package org.example.threads;

import java.util.ArrayList;

public class ThreadSequencial {
    private static volatile ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
//                synchronized (arr) {
                for (int i = 0; i < 10; i++) {
                    arr.add(i + 1);
                    Thread.sleep(100);
                }
//                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
//                lock.unlock();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
//                synchronized (arr) {
                for (int i = 0; i < 10; i++) {
                    arr.add(i + 11);
                    Thread.sleep(100);
//                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
//                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("Result: " + arr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t1.join();

        t2.start();
//        t2.join();

        t3.start();
//        t3.join();
    }
}
