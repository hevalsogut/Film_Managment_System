package FilmManagementSystem;

public class Review {
    // Review class to store review details
        public int rating;
        public String reviewText;

        public Review(int rating, String reviewText) {
            this.rating = rating;
            this.reviewText = reviewText;
        }

        public int getRating() {
            return rating;
        }

        public String getReviewText() {
            return reviewText;
        }
    }


