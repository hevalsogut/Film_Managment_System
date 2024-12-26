package FilmManagementSystem;

public class Actor {
    public String actorName;
    public int uniqueActorID;
    public LinkedList<Film> filmsParticipated;
    
    public Actor(String actorName, int uniqueActorID) {
        this.actorName = actorName;
        this.uniqueActorID = uniqueActorID;
        this.filmsParticipated = new LinkedList<>();
    }

    // Add a film to the actor's film list
    public void addFilm(Film film) {
        if (!filmsParticipated.search(film)) {
            filmsParticipated.add(film);
        }
    }
    
    // Aktörün film listesinde bir filmi siler
    public void removeFilm(Film film) {
        filmsParticipated.delete(film);  // Film'i listeden siler
        System.out.println(film.getFilmName() + " has been removed from " + actorName + "'s films.");
    }

    // Update actor profile
    public void updateActorProfile(String newActorName) {
        if (newActorName != null && !newActorName.isEmpty()) {
            this.actorName = newActorName; // Only update if the new name is not empty or null
        }
    }

    // Display actor details
    public void displayActorDetails() {
        System.out.println("Actor Name: " + actorName);
        System.out.println("Actor ID: " + uniqueActorID);
        System.out.print("Films Participated: ");
        filmsParticipated.display();
    }
    
    @Override
    public String toString() {
        return actorName;
    }

    public String getActorName() {
        return actorName;
    }

    public int getUniqueActorID() {
        return uniqueActorID;
    }

    public LinkedList<Film> getFilmsParticipated() {
        return filmsParticipated;
    }
}
