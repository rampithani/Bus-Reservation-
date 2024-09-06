# Bus-Reservation-
Project Title: Bus Reservation System

Overview: The Bus Reservation System is a Java-based application that allows users to book bus tickets online. The system will have the following features:

- User registration and login
- Bus schedule management (add, update, delete)
- Seat availability and booking
- Ticket generation and printing
- Payment gateway integration (for online payment)

Functional Requirements:

1. User Module:
    - User registration (name, email, password, contact number)
    - User login (email, password)
    - User profile management (update profile, change password)
2. Bus Module:
    - Add bus details (bus number, route, departure time, arrival time, seat capacity)
    - Update bus details
    - Delete bus details
3. Booking Module:
    - Search for available buses (by route, date, time)
    - Book a ticket (select seat, enter passenger details)
    - Generate ticket (with ticket number, passenger details, bus details)
4. Payment Module:
    - Integrate payment gateway (for online payment)
    - Process payment (generate payment receipt)

Non-Functional Requirements:

1. Security: User data and payment information should be secure.
2. Scalability: The system should be able to handle a large number of users and bookings.
3. Usability: The system should be user-friendly and easy to navigate.

Database Design:

1. Users table (user_id, name, email, password, contact_number)
2. Buses table (bus_id, bus_number, route, departure_time, arrival_time, seat_capacity)
3. Bookings table (booking_id, user_id, bus_id, ticket_number, passenger_details, payment_status)

Java Technologies Used:

1. Java Servlets (for server-side logic)
2. JavaServer Pages (JSP) (for user interface)
3. JDBC (for database connectivity)
4. Apache Tomcat (as the web server)

Project Structure:

1. BusReservationSystem (project folder)
    - src (source code folder)
        - com.busreservation (package)
            - User.java (user class)
            - Bus.java (bus class)
            - Booking.java (booking class)
            - Payment.java (payment class)
    - web (web pages folder)
        - index.jsp (home page)
        - login.jsp (login page)
        - registration.jsp (registration page)
        - booking.jsp (booking page)
        - payment.jsp (payment page)
    - resources (resources folder)
        - database.properties (database configuration file)
