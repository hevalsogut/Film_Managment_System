import java.util.*;

public class Value {

  public List<Integer> getList() {
    return list;
  }

  private List<Integer> list;

  public Value() {
    this.list = new ArrayList<>();
  }

  public void printList() {

    for (Integer i : this.list)
      System.out.print(i + " ");
  }

}
