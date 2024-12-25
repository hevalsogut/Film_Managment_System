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

    // Update actor profile
    public void updateActorProfile(String newActorName) {
        if (newActorName != null && !newActorName.isEmpty()) {
            this.actorName = newActorName; // Only update if the new name is not empty or null
        }
    }

    public void printActorDetails() {
        if (actors == null || actors.isEmpty()) {
            System.out.println("No actors available.");
            return;
        }

        System.out.print("Actors: ");
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i) != null) {
                System.out.print("Actor: " + actors.get(i).getActorName());
                if (i != actors.size() - 1) {
                    System.out.print(" -> ");
                }
            }
        }
        System.out.println(); // Ensure a new line after the actor list.
    }

    @Override
    public String toString() {
        return "Actor: " + actorName;
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
