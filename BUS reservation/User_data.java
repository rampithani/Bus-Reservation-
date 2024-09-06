package in.project1;

import java.util.ArrayList;
import java.util.Scanner;

public class User_data {
    Scanner s1 = new Scanner(System.in);
    Useres[] s = new Useres[20];
    int i = 0;

    class Useres {
        String name;
        String pass;
    }

    void Register() {
        Useres u = new Useres();
        System.out.print("enter the name:");
        u.name = s1.next();
        System.out.print("enter the password:");
        u.pass = s1.next();
        s[i] = u;
        i++;
    }

    void login(String name, String pwd) {
        int j;
        boolean find = false;
        for (j = 0; j < s.length - 1 && s[j] != null; j++) {
            if (s[j].name.equals(name)) {
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("DON'T HAVE AN ACCOUNT. PLEASE CREATE AN ACCOUNT.");
        } else {
            if (pwd.equals(s[j].pass)) {
                BusReg();
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }
    }

    void BusReg() {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        System.out.println("Welcome to REDBUS travels");
        Scanner sc = new Scanner(System.in);
        System.out.print("FROM:");
        String source = sc.next();
        System.out.print("TO:");
        String destination = sc.next();
        buses.add(new Bus(1, true, 2, 2000));
        buses.add(new Bus(2, false, 10, 1550));
        buses.add(new Bus(3, true, 20, 2100));

        int userOpt = 1;

        for (Bus b : buses) {
            b.displayBusInfo();
        }

        while (userOpt == 1) {
            System.out.print("Enter 1 to Book and 2 to exit:");
            userOpt = sc.nextInt();
            if (userOpt == 1) {
                Booking booking = new Booking(buses); // Pass the list of buses to Booking constructor
                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                } else {
                    System.out.println("Sorry. Bus is full. Try another bus or date.");
                }
            } else {
                System.out.println("Thank you!");
            }
        }
        //sc.close();
        System.out.println("!!!!!Please visit again!!!!!");
    }
}