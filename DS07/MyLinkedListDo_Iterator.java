package DataStructure.DS07;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/17
 * Time: 14:11
 * Description: No Description
 */
public class MyLinkedListDo_Iterator implements MyLinkedList_Iterator {
    private MyLinkedList list;
    private Node current;

    public MyLinkedListDo_Iterator(MyLinkedList list) {
        this.list = list;
        this.current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        int temp = current.element;
        current = current.next;
        return temp;
    }
}
