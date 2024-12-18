
public class LinkedList<T> {
  public Node<T> head;

  public LinkedList() {
    this.head = null;
  }

  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public boolean delete(T data) {
    if (head == null)
      return false;

    if (head.data.equals(data)) {
      head = head.next;
      return true;
    }

    Node<T> temp = head;
    while (temp.next != null && !temp.next.data.equals(data)) {
      temp = temp.next;
    }
    temp.next = temp.next.next;
    return true;
  }

  public boolean update(T oldData, T newData) {
    Node<T> temp = head;
    while (temp != null) {
      if (temp.data.equals(oldData)) {
        temp.data = newData;
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public void print() {
    Node<T> temp = head;
    System.out.println("List contents:");
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("List is empty.");
  }
}