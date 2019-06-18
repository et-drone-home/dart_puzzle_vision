import dependencies.User;

import java.sql.*;

public class UserDb {
    public static void seedDatabase(User user) {
        String url = "jdbc:sqlite:users.db";
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	email text NOT NULL,\n"
                + "	isActive integer,\n"
                + "	lastPaidDate integer \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            sql = "INSERT INTO users(email, isActive, lastPaidDate) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());
            pstmt.setBoolean(2, user.isActive());
            pstmt.setDate(3, Date.valueOf(user.getLastPaidDate()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void cleanDB () {
        String url = "jdbc:sqlite:users.db";

        String sql = "DELETE FROM users WHERE 1=1";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}