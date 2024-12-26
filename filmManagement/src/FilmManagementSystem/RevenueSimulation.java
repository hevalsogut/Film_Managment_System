package FilmManagementSystem;

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
            System.out.println("No films scheduled for screening.");
            return;
        }

        // Dequeue the next film for screening
        Film film = screenings.dequeue();

        // Assuming Film has getViewerCount and getTicketPrice methods
        int viewerCount = film.getViewerCount();
        double ticketPrice = film.getTicketPrice();
        double revenue = viewerCount * ticketPrice;

        // Push the revenue data onto the stack
        revenueHistory.push(new RevenueData(film.getFilmName(), revenue));

        // Output the simulation results
        System.out.println("Screened: " + film.getFilmName());
        System.out.println("Revenue generated: $" + revenue);
    }

    public void printScreeningSchedule() {
        System.out.println("Current Screening Schedule:");
        screenings.printQueue();
    }

    public void printRevenueHistory() {
        System.out.println("Revenue History (Stack):");
        revenueHistory.printStack();
    }
}
