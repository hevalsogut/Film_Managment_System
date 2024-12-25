package FilmManagementSystem;

public class Main {

    public static void main(String[] args) {
        Actor actor1 = new Actor("Leonardo DiCaprio", 1);
        Actor actor2 = new Actor("Emma Stone", 2);
        Actor actor3 = new Actor("Dwayne Johnson", 3);
        Actor actor4 = new Actor("Scarlett Johansson", 4);
        Actor actor5 = new Actor("Tom Hanks", 5);
        Actor actor6 = new Actor("Jennifer Lawrence", 6);
        Actor actor7 = new Actor("Brad Pitt", 7);
        Actor actor8 = new Actor("Angelina Jolie", 8);
        Actor actor9 = new Actor("Will Smith", 9);
        Actor actor10 = new Actor("Meryl Streep", 10);

        // Initialize films
        Film film1 = new Film("Inception", 1, "Sci-Fi", 2010, 8.8, 830000000, 14.0);
        Film film2 = new Film("La La Land", 2, "Musical", 2016, 8.0, 446000000, 18.0);
        Film film3 = new Film("Jumanji: Welcome to the Jungle", 3, "Adventure", 2017, 6.9, 962000000, 12.0);
        Film film4 = new Film("Avengers: Endgame", 4, "Action", 2019, 8.4, 279780000, 20.0);
        Film film5 = new Film("Forrest Gump", 5, "Drama", 1994, 8.8, 678000000, 16.0);
        Film film6 = new Film("The Hunger Games", 6, "Action", 2012, 7.2, 694000000, 14.0);
        Film film7 = new Film("Once Upon a Time in Hollywood", 7, "Drama", 2019, 7.6, 374000000, 19.0);
        Film film8 = new Film("Maleficent", 8, "Fantasy", 2014, 6.9, 758000000, 17.0);
        Film film9 = new Film("Bad Boys for Life", 9, "Action", 2020, 6.6, 426000000, 15.0);
        Film film10 = new Film("The Iron Lady", 10, "Biographical", 2011, 6.4, 114000000, 20.0);

        // Add actors to films
        film1.addActor(actor1);
        film1.addActor(actor2);
        film1.addActor(actor3);

        film2.addActor(actor3);
        film2.addActor(actor4);
        film2.addActor(actor5);

        film3.addActor(actor5);
        film3.addActor(actor6);
        film3.addActor(actor7);

        film4.addActor(actor7);
        film4.addActor(actor8);
        film4.addActor(actor9);

        film5.addActor(actor9);
        film5.addActor(actor10);
        film5.addActor(actor1);

        film6.addActor(actor2);
        film6.addActor(actor6);
        film6.addActor(actor8);

        film7.addActor(actor1);
        film7.addActor(actor3);
        film7.addActor(actor9);

        film8.addActor(actor4);
        film8.addActor(actor5);
        film8.addActor(actor7);

        film9.addActor(actor2);
        film9.addActor(actor8);
        film9.addActor(actor10);

        film10.addActor(actor3);
        film10.addActor(actor6);
        film10.addActor(actor10);

        // HashTable for films and actors
        HashTable<Integer, Film> filmsHashTable = new HashTable<>(10);
        filmsHashTable.put(film1.getUniqueFilmID(), film1);
        filmsHashTable.put(film2.getUniqueFilmID(), film2);
        filmsHashTable.put(film3.getUniqueFilmID(), film3);
        filmsHashTable.put(film4.getUniqueFilmID(), film4);
        filmsHashTable.put(film5.getUniqueFilmID(), film5);
        filmsHashTable.put(film6.getUniqueFilmID(), film6);
        filmsHashTable.put(film7.getUniqueFilmID(), film7);
        filmsHashTable.put(film8.getUniqueFilmID(), film8);
        filmsHashTable.put(film9.getUniqueFilmID(), film9);
        filmsHashTable.put(film10.getUniqueFilmID(), film10);

        // Binary Search Tree for searching films
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert("Inception");
        bst.insert("La La Land");
        bst.insert("Jumanji: Welcome to the Jungle");
        bst.insert("Avengers: Endgame");
        bst.insert("Forrest Gump");
        bst.insert("The Hunger Games");
        bst.insert("Once Upon a Time in Hollywood");
        bst.insert("Maleficent");
        bst.insert("Bad Boys for Life");
        bst.insert("The Iron Lady");

        // MaxHeap for popularity rankings
        MaxHeap popularityHeap = new MaxHeap(20);
        popularityHeap.insert(830); // Inception
        popularityHeap.insert(446); // La La Land
        popularityHeap.insert(962); // Jumanji: Welcome to the Jungle
        popularityHeap.insert(2797); // Avengers: Endgame
        popularityHeap.insert(678); // Forrest Gump
        popularityHeap.insert(694); // The Hunger Games
        popularityHeap.insert(374); // Once Upon a Time in Hollywood
        popularityHeap.insert(758); // Maleficent
        popularityHeap.insert(426); // Bad Boys for Life
        popularityHeap.insert(114); // The Iron Lady

        // Queue for screening films
        RevenueSimulation revenueSimulation = new RevenueSimulation(10);
        revenueSimulation.scheduleFilm(film1);
        revenueSimulation.scheduleFilm(film2);
        revenueSimulation.scheduleFilm(film3);
        revenueSimulation.scheduleFilm(film4);
        revenueSimulation.scheduleFilm(film5);

        revenueSimulation.simulateScreening();
        System.out.println("");
        revenueSimulation.printScreeningSchedule();
        System.out.println("");
        revenueSimulation.printRevenueHistory();
        System.out.println("");

        // Display popularity rankings
        popularityHeap.printHeap();

        // Search for a film using BST
        System.out.println("Searching for 'La La Land': " + bst.search("La La Land"));

        // Display film details
        film1.displayFilmDetails();
        film2.displayFilmDetails();
    }
}