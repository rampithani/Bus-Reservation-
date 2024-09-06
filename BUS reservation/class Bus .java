package in.project1;
public class Bus {
    private int busNo;
    private double price;
    private boolean ac;
    private int availableSeats;
    private boolean[] seats;

    public Bus(int no, boolean ac, int availableSeats, double price) {
        this.busNo = no;
        this.ac = ac;
        this.availableSeats = availableSeats;
        this.price = price;
        this.seats = new boolean[availableSeats];
    }

    public int getBusNo() {
        return busNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAc() {
        return ac;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean[] getSeats() {
        return seats;
    }

    public void setAc(boolean val) {
        ac = val;
    }

    public void setAvailableSeats(int cap) {
        availableSeats = cap;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + "  Ac: " + ac + "  Total Available seats: " + availableSeats + "  Price: " + price);
    }
}