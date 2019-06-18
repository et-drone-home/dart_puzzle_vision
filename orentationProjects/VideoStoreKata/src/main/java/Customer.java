import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    double totalAmount = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        int frequentRenterPoints = 0;

        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            double thisAmount = rental.getCost();
            totalAmount += thisAmount;
            frequentRenterPoints += rental.calculateRenterPoints();

            result += rental.getRentalStatement();
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}