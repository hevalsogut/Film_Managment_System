package FilmManagementSystem;

public class BSTNode {
    String name; // Name of the film or actor
    BSTNode left, right;
    Film film;

    public BSTNode(String name) {
        this.name = name;
        left = right = null;
    }
}
