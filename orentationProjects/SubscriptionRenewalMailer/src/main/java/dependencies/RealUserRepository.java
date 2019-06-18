package dependencies;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class RealUserRepository implements UserRepository {
    @Override
    public List<User> getUsers() {
        String url = "jdbc:sqlite:users.db";
        ArrayList<User> users = new ArrayList<User>();
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");

            while (rs.next()) {
                LocalDate lastPaidDate = rs.getDate("lastPaidDate").toLocalDate();
                boolean isActive = rs.getBoolean("isActive");
                String email = rs.getString("email");
                users.add(new User(isActive, lastPaidDate, email));
            }
        } catch (SQLException e) {
        }
        return users;
    }
}
