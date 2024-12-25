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
}

