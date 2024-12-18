public class BinarySearchTree {
  Node<Film> root;

  public BinarySearchTree() {
    root = null;
  }

  // Update method: updates the name and rebalances the tree
  public void updateFilmName(String oldName, String newName) {
    Node<Film> targetNode = findNode(root, oldName);

    if (targetNode != null) {
      Film updatedFilm = targetNode.data;
      updatedFilm.setFilmName(newName); // Update the film name using the setter

      // Delete the old node and insert the updated film
      deleteRecursive(oldName);
      insert(updatedFilm);
    } else {
      System.out.println("Film with name \"" + oldName + "\" not found in BST.");
    }
  }

  // Helper method to find a specific node
  private Node<Film> findNode(Node<Film> root, String filmName) {
    if (root == null)
      return null;

    int comparison = filmName.compareTo(root.data.getFilmName());
    if (comparison == 0)
      return root;
    else if (comparison < 0)
      return findNode(root.left, filmName);
    else
      return findNode(root.right, filmName);
  }

  // Delete method (by film name)
  public void deleteRecursive(String filmName) {
    root = deleteRecursive(root, filmName);
  }

  private Node<Film> deleteRecursive(Node<Film> root, String filmName) {
    if (root == null)
      return null;

    int comparison = filmName.compareTo(root.data.getFilmName());

    if (comparison < 0) {
      root.left = deleteRecursive(root.left, filmName);
    } else if (comparison > 0) {
      root.right = deleteRecursive(root.right, filmName);
    } else {
      // Deleting the node
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // If there are two children
      root.data = minValue(root.right);
      root.right = deleteRecursive(root.right, root.data.getFilmName());
    }
    return root;
  }

  private Film minValue(Node<Film> root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.data;
  }

  // Insert method
  public void insert(Film film) {
    root = insertRecursive(root, film);
  }

  private Node<Film> insertRecursive(Node<Film> root, Film film) {
    if (root == null) {
      return new Node<>(film);
    }

    if (film.getFilmName().compareTo(root.data.getFilmName()) < 0) {
      root.left = insertRecursive(root.left, film);
    } else if (film.getFilmName().compareTo(root.data.getFilmName()) > 0) {
      root.right = insertRecursive(root.right, film);
    }

    return root;
  }

  public void printInorder(Node<Film> root) {
    if (root != null) {
      printInorder(root.left);
      System.out.println("Film: " + root.data.getFilmName() + " (ID: " + root.data.uniqueFilmID + ")");
      printInorder(root.right);
    }
  }

  // Start inorder traversal from the root
  public void printInorder() {
    System.out.println("Inorder Traversal:");
    printInorder(root);
  }
}
