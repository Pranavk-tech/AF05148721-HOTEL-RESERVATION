package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationService service = new ReservationService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Delete Reservation");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addReservation();
                    break;
                case 2:
                    service.viewReservations();
                    break;
                case 3:
                    service.deleteReservation();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}