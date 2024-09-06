package in.project1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;
    Scanner scanner = new Scanner(System.in);
    private static final Map<Date, ArrayList<Booking>> bookingsByDate = new HashMap<>();
    private boolean[] seatStatus;

    public Booking(ArrayList<Bus> buses) {
        System.out.print("Enter name of passenger: ");
        passengerName = scanner.next();
        while (true) {
            System.out.print("Enter bus no (1, 2, or 3): ");
            busNo = scanner.nextInt();
            if (busNo >= 1 && busNo <= 3) {
                break; // Valid bus number, break out of the loop
            } else {
                System.out.println("Invalid bus number. Please enter 1, 2, or 3.");
            }
        }

        System.out.print("Enter date dd-mm-yyyy:");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Initialize seatStatus array for this booking instance
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                seatStatus = new boolean[bus.getAvailableSeats()];
                ArrayList<Booking> bookingsForBusAndDate = bookingsByDate.get(date);
                if (bookingsForBusAndDate != null) {
                    for (Booking booking : bookingsForBusAndDate) {
                        if (booking.busNo == busNo) {
                            seatStatus = booking.getSeatStatus();
                            break;
                        }
                    }
                }
                break;
            }
        }

        System.out.println("\nBus Seat Reservation System:");
        System.out.println("----------------------------");
        displayAvailableSeats(buses);
        System.out.println("----------------------------");
        System.out.println("Options:");
        System.out.println("1. Reserve a seat");
        System.out.println("2. Exit");
        System.out.print("Enter 1 to reserve a seat and 2 to exit:");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                reserveSeat(scanner, buses);
                break;
            case 2:
                System.out.println("Exiting the system. Thank you!");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        System.out.println("\nThank you for booking. Have a happy journey!");
    }

    private void displayAvailableSeats(ArrayList<Bus> buses) {
        System.out.println("Available Seats:");
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                int numSeats = bus.getAvailableSeats();
                for (int i = 0; i < numSeats; i++) {
                    if (!seatStatus[i]) {
                        System.out.print("[" + (i + 1) + "] ");
                    } else {
                        System.out.print("[X] ");
                    }
                }
                break;
            }
        }
        System.out.println();
    }

    private void reserveSeat(Scanner scanner, ArrayList<Bus> buses) {
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                int numSeats = bus.getAvailableSeats();
                System.out.print("Enter the seat number you want to reserve (1 - " + numSeats + "):");
                int seatNumber = scanner.nextInt();
                if (seatNumber >= 1 && seatNumber <= numSeats) {
                    if (!seatStatus[seatNumber - 1]) {
                        seatStatus[seatNumber - 1] = true;
                        ArrayList<Booking> bookingsForBusAndDate = bookingsByDate.get(date);
                        if (bookingsForBusAndDate == null) {
                            bookingsForBusAndDate = new ArrayList<>();
                            bookingsByDate.put(date, bookingsForBusAndDate);
                        }
                        bookingsForBusAndDate.add(this);
                        System.out.println("Seat " + seatNumber + " has been reserved.");
                        double amountToPay;
                        if (busNo == 1) {
                            System.out.println("Please pay 2000/-");
                            amountToPay = 2000;
                        } else if (busNo == 2) {
                            System.out.println("Please pay 1550/-");
                            amountToPay = 1550;
                        } else if (busNo == 3) {
                            System.out.println("Please pay 2100/-");
                            amountToPay = 2100;
                        } else {
                            // If bus number is not recognized, set a default amount
                            System.out.println("Invalid bus number. Please pay 1000/-");
                            amountToPay = 1000;
                        }

                        // Loop to handle incorrect amount input
                        while (true) {
                            System.out.print("Enter amount:");
                            double enteredAmount = scanner.nextDouble();
                            if (enteredAmount == amountToPay) {
                                System.out.println("Payment successful.");
                                break;
                            } else {
                                System.out.println("Wrong amount. Please enter the correct amount: " + amountToPay + "/-");
                            }
                        }
                    } else {
                        System.out.println("Sorry, Seat " + seatNumber + " is already occupied. Book another seat or bus.");
                    }
                } else {
                    System.out.println("Invalid seat number. Please try again.");
                }
                break;
            }
        }
    }

    public boolean[] getSeatStatus() {
        return seatStatus;
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int availableSeats = 0;
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                availableSeats = bus.getAvailableSeats();
                break;
            }
        }

        int booked = 0;
        ArrayList<Booking> bookingsForDate = bookingsByDate.get(date);
        if (bookingsForDate != null) {
            for (Booking b : bookingsForDate) {
                if (b.busNo == busNo) {
                    bo
