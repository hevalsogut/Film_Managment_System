public class Actor {
  private String actorName;
  private int uniqueActorID;
  private LinkedList<Film> filmsParticipated;

  public Actor(String name, int uniqueActorID) {
    this.actorName = name;
    this.uniqueActorID = uniqueActorID;
    this.filmsParticipated = new LinkedList<Film>();
  }

  public String getActorName() {
    return actorName;
  }

  public void setActorName(String actorName) {
    this.actorName = actorName;
  }

  public int getUniqueActorID() {
    return uniqueActorID;
  }

  public void setUniqueActorID(int uniqueActorID) {
    this.uniqueActorID = uniqueActorID;
  }

  public LinkedList<Film> getFilmsParticipated() {
    return filmsParticipated;
  }

  public void setFilmsParticipated(LinkedList<Film> filmsParticipated) {
    this.filmsParticipated = filmsParticipated;
  }

  public void addFilm(Film film) {
    getFilmsParticipated().add(film);
  }

  public void printFilms() {
    System.out.println("Films participated by " + getActorName() + ":");
    getFilmsParticipated().print();
  }
}
