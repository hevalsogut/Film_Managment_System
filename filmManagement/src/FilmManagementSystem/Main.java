package FilmManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Create some example Film objects
        Film film1 = new Film("Inception", 1, "Sci-Fi", 2010, 8.8, 2797, 12.99);
        Film film2 = new Film("La La Land", 2, "Musical", 2016, 8.0, 962, 10.99);
        Film film3 = new Film("Jumanji: Welcome to the Jungle", 3, "Adventure", 2017, 7.5, 830, 9.99);
        Film film4 = new Film("Avengers: Endgame", 4, "Action", 2019, 8.9, 678, 14.99);
        Film film5 = new Film("Forrest Gump", 5, "Drama", 1994, 8.8, 694, 11.99);

        // Create the RevenueSimulation and ViewerFeedbackSystem
        RevenueSimulation revenueSimulation = new RevenueSimulation(10);
        ViewerFeedbackSystem viewerFeedbackSystem = new ViewerFeedbackSystem(10);

        Actor actor1 = new Actor("Leonardo DiCaprio", 1);
        Actor actor2 = new Actor("Emma Stone", 2);
        Actor actor3 = new Actor("Dwayne Johnson", 3);
        Actor actor4 = new Actor("Scarlett Johansson", 4);
        Actor actor5 = new Actor("Tom Hanks", 5);

        film1.addActor(actor1);
        film1.addActor(actor2);
        film1.addActor(actor3);

        film2.addActor(actor2);
        film2.addActor(actor3);
        film2.addActor(actor4);

        film3.addActor(actor1);
        film3.addActor(actor4);
        film3.addActor(actor5);

        film4.addActor(actor2);
        film4.addActor(actor1);

        film5.addActor(actor5);
        film5.addActor(actor3);

        // Schedule films for screening
        revenueSimulation.scheduleFilm(film1);
        revenueSimulation.scheduleFilm(film2);
        revenueSimulation.scheduleFilm(film3);
        revenueSimulation.scheduleFilm(film4);
        revenueSimulation.scheduleFilm(film5);

        // Display scheduled films
        System.out.println("\n----- Scheduled Films -----");
        revenueSimulation.printScreeningSchedule();

        System.out.println("\n----- Simulating Screenings -----");
        film1.updateRevenue(); // Update the revenue for Inception
        System.out.println("Screened: Inception");
        System.out.printf("Revenue generated: $%.2f\n", film1.getTotalRevenue());

        film2.updateRevenue(); // Update the revenue for La La Land
        System.out.println("Screened: La La Land");
        System.out.printf("Revenue generated: $%.2f\n", film2.getTotalRevenue());

        film3.updateRevenue(); // Update the revenue for Jumanji
        System.out.println("Screened: Jumanji: Welcome to the Jungle");
        System.out.printf("Revenue generated: $%.2f\n", film3.getTotalRevenue());

        // Print revenue history
        revenueSimulation.printRevenueHistory();

        // Add films to the viewer feedback system
        viewerFeedbackSystem.addFilm(film1);
        viewerFeedbackSystem.addFilm(film2);
        viewerFeedbackSystem.addFilm(film3);
        viewerFeedbackSystem.addFilm(film4);
        viewerFeedbackSystem.addFilm(film5);

        // Add reviews
        viewerFeedbackSystem.addReview(1, 9, "Amazing movie!");
        viewerFeedbackSystem.addReview(2, 8, "Great music and performances.");
        viewerFeedbackSystem.addReview(3, 7, "Fun, but a bit predictable.");
        viewerFeedbackSystem.addReview(4, 10, "Epic conclusion to the saga!");
        viewerFeedbackSystem.addReview(5, 9, "A timeless classic.");

        // Display popularity ranking
        System.out.println("\n----- Popularity Ranking -----");
        viewerFeedbackSystem.displayPopularityRanking();

        // Display film details
        System.out.println("\n----- Film Details -----");
        viewerFeedbackSystem.displayFilmDetails(1); // Inception
        viewerFeedbackSystem.displayFilmDetails(2); // La La Land

        // Deleting a film
        System.out.println("\n----- Deleting a Film -----");
        film1.delete(viewerFeedbackSystem);
        viewerFeedbackSystem.displayFilmDetails(1); // Inception (should show "Film not found.")

        // Final status
        System.out.println("\n----- Final Status -----");
        revenueSimulation.printScreeningSchedule();
        revenueSimulation.printRevenueHistory();
        viewerFeedbackSystem.displayPopularityRanking();
    }
}
