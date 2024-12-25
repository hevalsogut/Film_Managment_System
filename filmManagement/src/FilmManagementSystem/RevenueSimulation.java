package FilmManagementSystem;

import java.text.DecimalFormat;

public class RevenueSimulation {
    public Queue<Film> screenings;
    public Stack<RevenueData> revenueHistory;

    public RevenueSimulation(int stackSize) {
        this.screenings = new Queue<>();
        this.revenueHistory = new Stack<>(stackSize);
    }

    public void scheduleFilm(Film film) {
        screenings.enqueue(film); // Add the Film object to the queue
        System.out.println("Scheduled film: " + film.getFilmName());
    }

    public void simulateScreening() {
        if (screenings.isEmpty()) {
            System.out.println("\nNo films scheduled for screening.\n");
            return;
        }

        Film film = screenings.dequeue();
        double revenue = film.getTotalRevenue(); // Automatically calculates total revenue

        // Format revenue to display without scientific notation
        DecimalFormat df = new DecimalFormat("#,###.00");
        String formattedRevenue = df.format(revenue);

        revenueHistory.push(new RevenueData(film.getFilmName(), revenue));

        System.out.println("\n==================== Screening Result ======================");
        System.out.println("Screened Film: " + film.getFilmName());
        System.out.println("Revenue Generated: $" + formattedRevenue);
        System.out.println("=============================================================\n");
    }

    public void printScreeningSchedule() {
        System.out.println("Current Screening Schedule:");
        screenings.printQueue();
    }

    public void printRevenueHistory() {
        if (revenueHistory.isEmpty()) {
            System.out.println("\nNo revenue history available.\n");
            return;
        }

        System.out.println("\n==================== Revenue History ======================");

        // Loop through the stack and print each film's revenue details
        for (int i = revenueHistory.size() - 1; i >= 0; i--) {
            RevenueData data = revenueHistory.get(i); // Get the RevenueData object at the given index
            String filmName = data.getFilmName();
            double revenue = data.getRevenue();

            // Format revenue with commas for readability
            DecimalFormat df = new DecimalFormat("#,###.00");
            String formattedRevenue = df.format(revenue);

            // Print the film name and formatted revenue
            System.out.printf("%d. Film: %-30s - Revenue: $%s\n", i + 1, filmName, formattedRevenue);
        }
        System.out.println("===========================================================");
    }

}
