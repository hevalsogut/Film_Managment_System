package FilmManagementSystem;

public class Node<T> {
    //Node method for LinkedList,Stack,Queue
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}