package org.example.threads;

import org.example.threads.runners.runners.OneThreadAccess;

public class ThreadSync {
    public static void main(String[] a) {
        OneThreadAccess ots = new OneThreadAccess(5000L);

        Thread threadWritter = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    ots.deduct(100);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread readerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(ots.getAmount());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadWritter.start();
        readerThread.start();
    }


}
