package org.example;

public class ThreadThrowExeception {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           throw new RuntimeException("Throwing exception from thread: " + Thread.currentThread().getName());
        });

        t1.setName("==Exception Thread==");
        t1.setUncaughtExceptionHandler((Thread t, Throwable thr) -> {
            System.out.println(t.getName() + "====> " + thr.getMessage());
        });

        t1.start();
    }
}
