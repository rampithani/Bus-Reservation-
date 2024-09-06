package in.project1;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {
        User_data us = new User_data();
        try (Scanner s = new Scanner(System.in)) {
            boolean f = false;
            while (!f) {
                System.out.println("please choose one option among these");
                System.out.println("[1].SIGN_UP\n[2].LOGIN\n[3].EXIT");
                int c = s.nextInt();
                switch (c) {
                    case 1:
                        us.Register();
                        break;
                    case 2:
                        System.out.print("enter the name:");
                        String name = s.next();
                        System.out.print("enter the password:");
                        String pwd = s.next();
                        us.login(name, pwd);
                        break;
                    case 3:
                        f = true;
                        System.out.println("Exiting the system.");
                        break;
                    default:
                        System.out.println("invalid option");
                }
            }
        }
    }
}