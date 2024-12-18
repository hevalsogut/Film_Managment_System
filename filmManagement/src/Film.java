public class Film {

  public String filmName;
  public int uniqueFilmID;
  public String genre;
  public int releaseYear;
  public double rating;
  public int rank = 1;
  public double totalRevenue;
  public int viewerCount;
  public BinarySearchTree bst;
  public LinkedList<Actor> actorList;

  // Constructor
  public Film(String filmName, int uniqueFilmID, String genre, int releaseYear, double rating, int viewerCount,
      double totalRevenue, BinarySearchTree bst) {
    this.filmName = filmName;
    this.uniqueFilmID = uniqueFilmID;
    this.genre = genre;
    this.releaseYear = releaseYear;
    this.rating = rating;
    this.viewerCount = viewerCount;
    this.totalRevenue = totalRevenue;
    this.bst = bst;
    this.actorList = new LinkedList<>();
  }

  // Getters and Setters for the fields
  public String getFilmName() {
    return filmName;
  }

  public void setFilmName(String filmName) {
    this.filmName = filmName;
  }

  public int getUniqueFilmID() {
    return uniqueFilmID;
  }

  public void setUniqueFilmID(int uniqueFilmID) {
    this.uniqueFilmID = uniqueFilmID;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public int getViewerCount() {
    return viewerCount;
  }

  public void setViewerCount(int viewerCount) {
    this.viewerCount = viewerCount;
  }

  public BinarySearchTree getBst() {
    return bst;
  }

  public void setBst(BinarySearchTree bst) {
    this.bst = bst;
  }

  public LinkedList<Actor> getActorList() {
    return actorList;
  }

  public void setActorList(LinkedList<Actor> actorList) {
    this.actorList = actorList;
  }

  // Method to add an actor to the film
  public void addActor(Actor actor) {
    actorList.add(actor);
  }

  // Method to update the name of the film
  public void updateName(String newName) {
    this.filmName = newName;
  }

  // Method to calculate revenue
  public void calculateRevenue() {
    this.totalRevenue = viewerCount * 10; // Assuming each viewer contributes 10 units to revenue
  }

  // Method to rate the film
  public void rateFilm(double rating) {
    this.rating = rating;
  }
}
