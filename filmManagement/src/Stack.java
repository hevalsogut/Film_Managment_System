public class Stack<T> {
  private Object[] s_array;
  private int top;

  // Constructor to initialize the stack with a given size
  public Stack(int size) {
    s_array = new Object[size];
    top = -1;
  }

  // Push an element onto the stack
  public void push(T data) {
    if (this.isFull()) {
      resize(); // Resize the array if the stack is full
    }
    s_array[++top] = data; // Increment top and add data to the stack
  }

  public T pop() {
    if (this.isEmpty()) {
      System.out.println("Stack is Empty");
      return null;
    } else {
      @SuppressWarnings("unchecked")
      T element = (T) s_array[top]; // Cast the top element safely
      top--; // Decrement the top pointer
      return element;
    }
  }

  // Check if the stack is full
  public boolean isFull() {
    return top == s_array.length - 1;
  }

  // Check if the stack is empty
  public boolean isEmpty() {
    return top == -1;
  }

  // Resize the stack array when it's full
  private void resize() {
    Object[] newArray = new Object[s_array.length * 2]; // Double the size
    System.arraycopy(s_array, 0, newArray, 0, s_array.length); // Copy old data into the new array
    s_array = newArray; // Update the stack array to the new one
  }

  // Print the contents of the stack
  public void printStack() {
    for (int i = top; i >= 0; i--) {
      System.out.println(s_array[i] + (i == top ? " ----> Top" : ""));
    }
  }
}
