public class Queue<T> {
  private Node<T> front;
  private Node<T> rear;
  private int size;

  // Constructor to initialize the queue
  public Queue() {
    front = null;
    rear = null;
    size = 0;
  }

  // Method to enqueue data
  public void enqueue(T data) {
    Node<T> newNode = new Node<>(data); // Create a new node with the given data

    if (rear == null) {
      front = newNode;
      rear = newNode; // If the queue is empty, both front and rear point to the new node
    } else {
      rear.next = newNode; // Attach the new node at the rear
      rear = newNode; // Move the rear pointer to the new node
    }
    size++; // Increment size
  }

  // Method to dequeue data
  public Node<T> dequeue() {
    if (front == null) {
      System.out.println("Queue is empty");
      return null;
    } else {
      Node<T> dequeuedNode = front; // Save the front node to return
      front = front.next; // Move the front pointer to the next node
      size--; // Decrement size
      if (front == null) { // If the queue is empty after dequeue
        rear = null; // Set rear to null
      }
      return dequeuedNode;
    }
  }

  // Method to check if the queue is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Method to print the elements in the queue
  public void printQueue() {
    if (!isEmpty()) {
      Node<T> current = front;
      while (current != null) {
        System.out.print(current.data + (current.next != null ? " -> " : ""));
        current = current.next;
      }
      System.out.println();
    }
  }

  // Node class for the queue
  private static class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
}
