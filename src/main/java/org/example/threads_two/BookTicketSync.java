package org.example.threads_two;

public class BookTicketSync implements Runnable {
    private int tickets;
    static int i = 2, j = 3, k = 1;

    public BookTicketSync(int tickets) {
        this.tickets = tickets;
    }

    public static void main(String ar[]) {
        BookTicketSync bookTicketSync = new BookTicketSync(5);
        Thread t1 = new Thread(bookTicketSync);
        Thread t2 = new Thread(bookTicketSync);
        Thread t3 = new Thread(bookTicketSync);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.equals("t1")) {
            bookticket(name, i);
        } else if (name.equals("t2")) {
            bookticket(name, j);
        } else {
            bookticket(name, k);
        }
    }

    synchronized void bookticket(String name, int wantedtickets) {
        if (wantedtickets <= tickets) {
            System.out.println(wantedtickets + " booked to " + name);
            tickets = tickets - wantedtickets;
        } else {
            System.out.println("No tickets to book");
        }
    }
}
