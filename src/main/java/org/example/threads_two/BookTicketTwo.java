package org.example.threads_two;

import org.example.threads_two.models.TicketStore;

public class BookTicketTwo {

    public static void main(String[] a) {

        TicketStore ticketStore = new TicketStore(6);

        Thread t1 = new Thread(() -> {
            synchronized(ticketStore) {
                ticketStore.book(3);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized(ticketStore) {
                ticketStore.book(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized(ticketStore) {
                ticketStore.book(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.setName("AA");
        t2.setName("BB");
        t3.setName("CC");

        t1.start();
        t2.start();
        t3.start();

    }
}
