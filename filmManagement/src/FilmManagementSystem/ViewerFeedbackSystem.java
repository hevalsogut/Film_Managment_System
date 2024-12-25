package FilmManagementSystem;

import java.text.DecimalFormat;

public class ViewerFeedbackSystem {
    private HashTable<Integer, Film> filmDatabase;
    private LinkedList<Film> popularityRanking;

    public ViewerFeedbackSystem(int capacity) {
        this.filmDatabase = new HashTable<>(capacity);
        this.popularityRanking = new LinkedList<>();
    }

    public void addFilm(Film film) {
        if (film != null) {
            filmDatabase.put(film.getUniqueFilmID(), film);
            popularityRanking.add(film);
            sortFilmsByPopularity();
        } else {
            System.out.println("Invalid film.");
        }
    }

    public Film getFilm(int uniqueFilmID) {
        return filmDatabase.get(uniqueFilmID);
    }

    public void addReview(int uniqueFilmID, int rating, String reviewText) {
        Film film = getFilm(uniqueFilmID);
        if (film != null) {
            film.addReview(rating, reviewText);
            System.out.println("Review added successfully.");
            sortFilmsByPopularity();
        } else {
            System.out.println("Film not found.");
        }
    }

    public void displayFilmDetails(int uniqueFilmID) {
        Film film = getFilm(uniqueFilmID);
        if (film != null) {
            System.out.println("\n======================== Film Details ========================");
            System.out.printf("Film Name: %-30s | Film ID: %-4d | Genre: %-15s | Release Year: %-4d\n",
                    film.getFilmName(), film.getUniqueFilmID(), film.getGenre(), film.getReleaseYear());
            System.out.printf("Total Revenue: $%-10s\n", formatRevenue(film.getTotalRevenue()));
            System.out.println("---------------------------------------------------------------");
            System.out.print("Actors: ");
            Node<Actor> currentActor = film.getActorList().head;
            while (currentActor != null) {
                System.out.print(currentActor.data.getActorName());
                if (currentActor.next != null) {
                    System.out.print(" -> ");
                }
                currentActor = currentActor.next;
            }
            System.out.println("\n===============================================================");
        } else {
            System.out.println("Film not found.");
        }
    }

    // Format revenue to avoid scientific notation and improve output
    private String formatRevenue(double revenue) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(revenue);
    }

    public double getAverageRating(int uniqueFilmID) {
        Film film = getFilm(uniqueFilmID);
        if (film != null) {
            LinkedList<Review> reviews = film.getReviews();
            double totalRating = 0;
            int reviewCount = 0;

            Node<Review> current = reviews.head;
            while (current != null) {
                totalRating += current.data.getRating();
                reviewCount++;
                current = current.next;
            }

            return reviewCount > 0 ? totalRating / reviewCount : 0;
        }
        return 0;
    }

    public void sortFilmsByPopularity() {
        popularityRanking.sort((film1, film2) -> {
            double popularity1 = getAverageRating(film1.getUniqueFilmID()) * film1.getReviews().size();
            double popularity2 = getAverageRating(film2.getUniqueFilmID()) * film2.getReviews().size();
            return Double.compare(popularity2, popularity1);
        });
    }

    public void displayPopularityRanking() {
        System.out.println("\n==================== Film Popularity Rankings ====================");
        for (int i = 0; i < popularityRanking.size(); i++) {
            Film film = popularityRanking.get(i);
            double avgRating = getAverageRating(film.getUniqueFilmID());
            int reviewCount = getReviewCount(film.getUniqueFilmID());
            System.out.printf("%d. %-30s - Avg Rating: %.2f - Total Reviews: %d\n",
                    (i + 1),
                    film.getFilmName(),
                    avgRating,
                    reviewCount);
        }
        System.out.println("====================================================================\n");
    }

}
