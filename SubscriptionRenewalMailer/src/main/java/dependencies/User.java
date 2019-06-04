package dependencies;


import java.time.LocalDate;
import java.util.Objects;

public class User {
    private boolean isActive;
    private LocalDate lastPaidDate;
    private String email;

    public User(boolean isActive, LocalDate lastPaidDate, String email) {
        this.isActive = isActive;
        this.lastPaidDate = lastPaidDate;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive &&
                Objects.equals(lastPaidDate, user.lastPaidDate) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive, lastPaidDate, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "isActive=" + isActive +
                ", lastPaidDate=" + lastPaidDate +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getLastPaidDate() {
        return lastPaidDate;
    }

    public void setLastPaidDate(LocalDate lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
