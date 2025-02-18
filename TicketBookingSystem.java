class TicketBooking {
    private static final int TOTAL_SEATS = 5; // Total number of seats available
    private int availableSeats = TOTAL_SEATS;


    public synchronized boolean bookSeat(String customerType) {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println(customerType + " booked a seat. Remaining seats: " + availableSeats);
            return true;
        } else {
            System.out.println("No available seats for " + customerType);
            return false;
        }
    }
}

class BookingThread extends Thread {
    private TicketBooking ticketBooking;
    private String customerType;

    public BookingThread(TicketBooking ticketBooking, String customerType) {
        this.ticketBooking = ticketBooking;
        this.customerType = customerType;
    }

    @Override
    public void run() {

        ticketBooking.bookSeat(customerType);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();

    
        BookingThread customer1 = new BookingThread(ticketBooking, "Regular Customer 1");
        BookingThread customer2 = new BookingThread(ticketBooking, "Regular Customer 2");
        BookingThread customer3 = new BookingThread(ticketBooking, "VIP Customer 1"); // VIP Customer


        customer3.setPriority(Thread.MAX_PRIORITY); 
        customer1.setPriority(Thread.NORM_PRIORITY);
        customer2.setPriority(Thread.NORM_PRIORITY); 

        
        customer3.start();  
        customer1.start();
        customer2.start();
    }
}
