package org.example;

public class ThreadInterruption {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new WaitingForThread());
        t.setName("WaitingForThread");
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }

    private static class WaitingForThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - Thread is Interrupted.");
            }
        }
    }
}
