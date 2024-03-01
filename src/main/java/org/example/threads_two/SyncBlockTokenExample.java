package org.example.threads_two;

public class SyncBlockTokenExample implements Runnable {
    int token = 1;

    public static void main(String[] args) {
        SyncBlockTokenExample a1 = new SyncBlockTokenExample();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a1);
        t1.setName("user1");
        t2.setName("user2");
        t3.setName("user3");
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
//        synchronized (this) {
            Thread t = Thread.currentThread();
            String name = t.getName();
            System.out.println(token + ".....alloted to " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            token++;
//        }
    }
}
