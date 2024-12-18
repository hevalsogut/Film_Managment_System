public class Main {
  public static void main(String[] args) {
    // Create FilmManager instance
    FilmManager filmManager = new FilmManager();
    BinarySearchTree bst = new BinarySearchTree();
    // Create some films
    Film film1 = new Film("Inception", 1, "Sci-Fi", 2010, 8.8, 10000000, 5000000, bst);
    Film film2 = new Film("Titanic", 2, "Romance", 1997, 7.8, 20000000, 8000000, bst);
    Film film3 = new Film("The Dark Knight", 3, "Action", 2008, 9.0, 15000000, 10000000, bst);
    Film film4 = new Film("Avengers: Endgame", 4, "Action", 2019, 8.4, 25000000, 20000000, bst);
    Film film5 = new Film("The Matrix", 5, "Sci-Fi", 1999, 8.7, 12000000, 7000000, bst);

    // Add films to FilmManager
    filmManager.addFilm(film1);
    filmManager.addFilm(film2);
    filmManager.addFilm(film3);
    filmManager.addFilm(film4);
    filmManager.addFilm(film5);

    // Create some actors and link them to films
    Actor actor1 = new Actor("Leonardo DiCaprio", 1);
    Actor actor2 = new Actor("Kate Winslet", 2);
    Actor actor3 = new Actor("Christian Bale", 3);
    Actor actor4 = new Actor("Robert Downey Jr.", 4);
    Actor actor5 = new Actor("Keanu Reeves", 5);

    film1.addActor(actor1);
    film2.addActor(actor2);
    film3.addActor(actor3);
    film4.addActor(actor4);
    film5.addActor(actor5);

    // Display all films and their actors
    System.out.println("Films and Actors:\n");
    filmManager.printFilms();

  }
}
