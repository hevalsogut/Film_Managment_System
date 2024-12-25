package FilmManagementSystem;

public class Film {
    private String filmName;
    private int uniqueFilmID;
    private LinkedList<Actor> actorList;
    private String genre;
    private int releaseYear;
    private double totalRevenue;
    private int viewerCount;
    private double ticketPrice;
    private LinkedList<Review> reviews; // LinkedList to store reviews

    public Film(String filmName, int uniqueFilmID, String genre, int releaseYear, double totalRevenue, int viewerCount,
            double ticketPrice) {
        this.filmName = filmName;
        this.uniqueFilmID = uniqueFilmID;
        this.actorList = new LinkedList<>();
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = totalRevenue;
        this.viewerCount = viewerCount;
        this.ticketPrice = ticketPrice;
        this.reviews = new LinkedList<>(); // Initialize reviews list
    }

    // Add an actor to the film's actor list
    public void addActor(Actor actor) {
        if (!actorList.search(actor)) {
            getActorList().add(actor);
            actor.addFilm(this); // Update the actor's film list
        }
    }

    // Remove an actor from the film's actor list
    public boolean deleteActor(Actor actor) {
        return getActorList().delete(actor);
    }

    public void updateFilmDetails(String filmName, String genre, int releaseYear, double totalRevenue, int viewerCount,
            double ticketPrice) {
        if (filmName != null && !filmName.isEmpty()) {
            this.setFilmName(filmName); // Update only if the new film name is valid
        }
        if (genre != null && !genre.isEmpty()) {
            this.setGenre(genre); // Update only if the new genre is valid
        }
        if (releaseYear > 0) {
            this.setReleaseYear(releaseYear); // Update only if the release year is positive
        }
        if (totalRevenue >= 0) {
            this.setTotalRevenue(totalRevenue); // Update only if the total revenue is non-negative
        }
        if (viewerCount >= 0) {
            this.setViewerCount(viewerCount);
        }
        if (ticketPrice >= 0) {
            this.setTicketPrice(ticketPrice);
        }
    }

    // Add a review for the film
    public void addReview(int rating, String reviewText) {
        Review review = new Review(rating, reviewText);
        this.getReviews().add(review); // Add the review to the film's review list
    }

    public void displayFilmDetails() {
        System.out.println("======================== Film Details ========================");
        System.out.println("Film Name: " + filmName);
        System.out.println("Film ID: " + uniqueFilmID);
        System.out.println("Genre: " + genre);
        System.out.println("Release Year: " + releaseYear);
        System.out.printf("Total Revenue: $%,.2f\n", getTotalRevenue());
        System.out.println("--------------------------------------------------------------");

        System.out.print("Actors: ");
        Node<Actor> currentActor = actorList.head;
        while (currentActor != null) {
            System.out.print("Actor: " + currentActor.data.getActorName());
            if (currentActor.next != null) {
                System.out.print(" -> ");
            }
            currentActor = currentActor.next;
        }
        System.out.println("\n===============================================================");
    }

    @Override
    public String toString() {
        return "Film: " + filmName + " (" + releaseYear + "), Genre: " + genre;
    }

    public void calculateTotalRevenue() {
        this.totalRevenue = this.ticketPrice * this.viewerCount;
    }

    public String getFilmName() {
        return filmName;
    }

    public int getUniqueFilmID() {
        return uniqueFilmID;
    }

    public LinkedList<Actor> getActorList() {
        return actorList;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getTotalRevenue() {
        calculateTotalRevenue();
        return totalRevenue;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setUniqueFilmID(int uniqueFilmID) {
        this.uniqueFilmID = uniqueFilmID;
    }

    public void setActorList(LinkedList<Actor> actorList) {
        this.actorList = actorList;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setViewerCount(int viewerCount) {
        this.viewerCount = viewerCount;
        calculateTotalRevenue();
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
        calculateTotalRevenue();
    }

    public LinkedList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(LinkedList<Review> reviews) {
        this.reviews = reviews;
    }

}
