package dependencies;


import java.time.LocalDate;
import java.util.Objects;

public class User {
    private boolean isActive;
    private LocalDate lastPaidDate;
    private String name;

    public User(boolean isActive, LocalDate lastPaidDate, String name) {
        this.isActive = isActive;
        this.lastPaidDate = lastPaidDate;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive &&
                Objects.equals(lastPaidDate, user.lastPaidDate) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive, lastPaidDate, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "isActive=" + isActive +
                ", lastPaidDate=" + lastPaidDate +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
