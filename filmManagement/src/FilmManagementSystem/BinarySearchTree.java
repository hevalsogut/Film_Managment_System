package FilmManagementSystem;

public class BinarySearchTree {
    BSTNode root;
    public BinarySearchTree() {
        root = null;
    }

    // Insert a name into the BST
    public void insert(String name) {
        root = insertRecursive(root, name);
    }

    public BSTNode insertRecursive(BSTNode root, String name) {
        if (root == null) {
            return new BSTNode(name);
        }
        if (name.compareTo(root.name) < 0) {
            root.left = insertRecursive(root.left, name);
        } else if (name.compareTo(root.name) > 0) {
            root.right = insertRecursive(root.right, name);
        }
        return root;
    }

    // Search for a name in the BST
    public boolean search(String name) {
        return searchRecursive(root, name);
    }

    public boolean searchRecursive(BSTNode root, String name) {
        if (root == null) {
            return false;
        }
        if (name.equals(root.name)) {
            return true;
        }
        if (name.compareTo(root.name) < 0) {
            return searchRecursive(root.left, name);
        } else {
            return searchRecursive(root.right, name);
        }
    }

    // In-order traversal to print sorted names
    public void printInOrder() {
        printInOrderRecursive(root);
    }

    public void printInOrderRecursive(BSTNode root) {
        if (root != null) {
            printInOrderRecursive(root.left);
            System.out.print(root.name + " ");
            printInOrderRecursive(root.right);
        }
    }
    
    // Silme fonksiyonu BST'de film nesnesini silmek için
    public void removeFilmFromBST(Film film) {
    root = removeRecursive(root, film); // root BSTNode türünde olmalı
}

    private BSTNode removeRecursive(BSTNode current, Film film) {
    if (current == null) {
        return null;
    }

    // Film küçükse soldan sil
    if (film.getUniqueFilmID() < current.film.getUniqueFilmID()) {
        current.left = removeRecursive(current.left, film);
    } 
    // Film büyükse sağdan sil
    else if (film.getUniqueFilmID() > current.film.getUniqueFilmID()) {
        current.right = removeRecursive(current.right, film);
    } 
    // Film bulundu
    else {
        // Düğümde tek bir çocuk varsa
        if (current.left == null) {
            return current.right;
        } else if (current.right == null) {
            return current.left;
        }

        // Her iki çocuk varsa, en küçük öğeyi bulup yerleştir
        Film smallestFilm = findSmallestFilm(current.right);
        current.film = smallestFilm;
        current.right = removeRecursive(current.right, smallestFilm);
    }

    return current;
}

    private Film findSmallestFilm(BSTNode root) {
    return root.left == null ? root.film : findSmallestFilm(root.left);
}


}

