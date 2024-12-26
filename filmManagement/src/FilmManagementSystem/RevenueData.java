package FilmManagementSystem;

public class RevenueData {
    // RevenueData class for storing revenue information in the stack
    public String filmName;
    public double revenue;

    public RevenueData(String filmName, double revenue) {
        this.filmName = filmName;
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return filmName + ": $" + revenue;
    }
}
