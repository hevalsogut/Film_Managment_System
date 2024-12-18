public class HashTable {

  public final LinkedList<Film>[] table;

  @SuppressWarnings("unchecked")
  public HashTable(int tableSize) {
    this.table = new LinkedList[tableSize];

    // Initialize each bucket with a new LinkedList
    for (int i = 0; i < tableSize; i++) {
      table[i] = new LinkedList<>();
    }
  }

  public void add(Film film) {
    int index = hash(film.getUniqueFilmID()); // Use getter to access uniqueFilmID
    table[index].add(film);
  }

  public int hash(int filmID) {
    // Simple hash function that uses modulo operation to find the correct bucket
    return filmID % table.length;
  }

  public boolean remove(int filmID) {
    int index = hash(filmID);
    Film film = find(filmID);
    if (film != null) {
      return table[index].delete(film); // Delete the film from the linked list at the bucket
    }
    return false; // Film not found
  }

  public Film find(int filmID) {
    int index = hash(filmID);
    Node<Film> temp = table[index].head;
    while (temp != null) {
      if (temp.data.uniqueFilmID == filmID) {
        return temp.data; // Return the film if found
      }
      temp = temp.next;
    }
    return null; // Film not found
  }

  public boolean update(int filmID, Film newFilm) {
    int index = hash(filmID);
    Node<Film> temp = table[index].head;
    while (temp != null) {
      if (temp.data.uniqueFilmID == filmID) {
        temp.data = newFilm; // Update the film data at the correct position
        return true;
      }
      temp = temp.next;
    }
    return false; // Film not found to update
  }

  public void printTable() {
    // Print the hash table with each bucket's contents
    for (int i = 0; i < table.length; i++) {
      System.out.print("Bucket " + i + ": ");
      table[i].print(); // Print all elements in the linked list at this bucket
    }
  }
}
