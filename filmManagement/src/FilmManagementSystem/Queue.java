package FilmManagementSystem;

public class Queue<T> {
    public Node<T> front;
    public Node<T> rear;
    public int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add an element to the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return the front element
    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public void remove(T film) {
        if (front == null)
            return;

        if (front.data.equals(film)) {
            front = front.next;
            return;
        }

        Node<T> current = front;
        while (current.next != null) {
            if (current.next.data.equals(film)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {

        if (!isEmpty()) {

            @SuppressWarnings("rawtypes")
            Node current = front;
            while (current != null) {
                System.out.println(current.data + (current.next != null ? "" : ""));
                current = current.next;
            }
            System.out.println();
        }
    }

}
