package org.example.threads_two.models;

public class TicketStore {
    private int availableTickets;

    public TicketStore(int tickets) {
        this.availableTickets = tickets;
    }

    public void book(int bookings) {
        System.out.println("Available:" + availableTickets);
        if (bookings <= availableTickets) {
            this.availableTickets -= bookings;
            System.out.println(bookings + " Tickets Book for: " + Thread.currentThread().getName());
        } else System.out.println("Ticket not available.");
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

}
