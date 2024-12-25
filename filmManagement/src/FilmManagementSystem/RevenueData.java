package FilmManagementSystem;

public class RevenueData {
    private String filmName;
    private double revenue;

    public RevenueData(String filmName, double revenue) {
        this.filmName = filmName;
        this.revenue = revenue;
    }

    public String getFilmName() {
        return filmName;
    }

    public double getRevenue() {
        return revenue;
    }
}
