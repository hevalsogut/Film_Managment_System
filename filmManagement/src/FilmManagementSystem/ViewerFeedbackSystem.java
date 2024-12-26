package FilmManagementSystem;

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

    public void removeFilmFromDatabase(int uniqueFilmID) {
        filmDatabase.remove(uniqueFilmID);
    }

    // Method to remove film from the popularity ranking (linked list)
    public void removeFilmFromRanking(Film film) {
        popularityRanking.delete(film);
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
            film.displayFilmDetails();
        } else {
            System.out.println("Film not found.");
        }
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
        for (int i = 0; i < popularityRanking.size(); i++) {
            Film film = popularityRanking.get(i);
            System.out.println(film.getFilmName() + " - Average Rating: " + getAverageRating(film.getUniqueFilmID()));
        }
    }
}
