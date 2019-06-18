public class RegularMovie extends Movie {
    public static final int REGULAR = 0;


    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getMovieCost(int daysRented) {
        double thisAmount = 0;
        thisAmount += 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }
}