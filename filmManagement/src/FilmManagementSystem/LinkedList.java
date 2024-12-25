package FilmManagementSystem;

public class LinkedList<T> {
    public Node<T> head;
    public int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a new node to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Delete a node with the given data
    public boolean delete(T data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            previous.next = current.next;
            size--;
            return true;
        }
        return false;
    }

    // Search for a node with the given data
    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the contents of the list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get the size of the linked list
    public int size() {
        return size;
    }

    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null) {
            return; // List is empty or has only one element
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;

            while (current.next != null) {
                if (comparator.compare(current.data, current.next.data) > 0) {
                    // Swap data between current and next
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    interface Comparator<T> {
        int compare(T o1, T o2);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }

        return null; // Bu satır teorik olarak hiçbir zaman çalışmaz
    }

}