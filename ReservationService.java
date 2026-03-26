package hotel;

import java.sql.*;
import java.util.Scanner;

public class ReservationService {

    public void addReservation() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Guest Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Number: ");
        int room = sc.nextInt();

        System.out.print("Enter Nights: ");
        int nights = sc.nextInt();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO reservations(guest_name, room_number, nights) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, room);
            ps.setInt(3, nights);

            ps.executeUpdate();
            System.out.println("Reservation Added!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewReservations() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM reservations";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("guest_name") + " | " +
                    rs.getInt("room_number") + " | " +
                    rs.getInt("nights")
                );
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Reservation ID to delete: ");
        int id = sc.nextInt();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM reservations WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("Record not found.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}