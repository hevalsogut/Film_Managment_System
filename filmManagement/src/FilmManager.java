public class FilmManager {
  private Film[] films;
  private int filmCount;

  public FilmManager() {
    films = new Film[1];
    filmCount = 0;
  }

  public void addFilm(Film film) {
    if (filmCount == films.length) {
      resizeArray();
    }
    films[filmCount++] = film;
  }

  private void resizeArray() {
    Film[] newArray = new Film[films.length * 2];
    for (int i = 0; i < films.length; i++) {
      newArray[i] = films[i];
    }
    films = newArray;
  }

  public void updateRank() {
    for (int i = 0; i < filmCount - 1; i++) {
      for (int j = 0; j < filmCount - i - 1; j++) {
        if ((films[j].getRating() * films[j].getTotalRevenue()) < (films[j + 1].getRating()
            * films[j + 1].getTotalRevenue())) {
          Film temp = films[j];
          films[j] = films[j + 1];
          films[j + 1] = temp;
        }
      }
    }

    for (int i = 0; i < filmCount; i++) {
      films[i].setRank(i + 1);
    }
  }

  public void printFilms() {
    for (int i = 0; i < filmCount; i++) {
      System.out.println("Film: " + films[i].getFilmName() + ", Rating: " + films[i].getRating() + ", Rank: "
          + films[i].getRank() + ", Total Revenue: " + films[i].getTotalRevenue());
    }
  }
}
