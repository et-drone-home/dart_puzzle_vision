public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCost() {
        return movie.getMovieCost(this.getDaysRented());
    }

    public int calculateRenterPoints() {
        int frequentRenterPoints = 1;
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public String getRentalStatement() {
        return "\t" + movie.getTitle() + "\t" + getCost() + "\n";
    }
}