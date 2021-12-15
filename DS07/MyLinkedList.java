package DataStructure.DS07;

import DataStructure.DS06.MyIterator;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 17:33
 * Description: No Description
 */
public class MyLinkedList implements MyInt_List{
    public Node head;  //指向第一个结点
    public Node last;  //指向最后一个结点
    public int size;

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        Node cur = head;
        while (cur != null){
            stringBuffer.append(cur.element);
            if (cur.next != null){
                stringBuffer.append(", ");
            }
            cur = cur.next;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public Node findPrevNode(int index){  //找到Index的前一个结点
        Node curPrev;  //找到下标位置的前一个元素
        if(index-1 < size/2){  //要找到index-1位置的元素，那么判断从前找还是从后面找更快
            curPrev = head;
            for (int i = 0; i < index-1; i++) {  //不懂画图举例
                curPrev = curPrev.next;
            }
        }else {
            curPrev = last;
            for (int i = 0; i < size-index; i++) {  //不懂画图举例
                curPrev = curPrev.prev;
            }
        }
        return curPrev;
    }

    @Override
    public boolean add(Integer e) {
        Node node = new Node(e);
        if (head == null){
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        if (index < 0||index > size){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        Node node = new Node(e);
        if (head == null){
            head = node;
            last = node;
            return;
        }
        if (index == 0){
            node.next = head;
            head.prev = node;
            head = node;
            size++;
            return;
        }

        if (index == size){
            add(e);
            return;
        }

        Node curPrev = findPrevNode(index);

        node.next = curPrev.next;
        curPrev.next.prev = node;
        curPrev.next = node;
        node.prev = curPrev;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > this.size-1){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        if (head == null){
            throw new NullPointerException("链表为空，不能删除");
        }

        if (size == 1){
            int temp = head.element;
            head = last = null;
            size--;
            return temp;
        }
        int toReturn;
        if (index == 0){
            toReturn = head.element;
            head = head.next;
            head.prev = null;
            size--;
        }else if (index == this.size-1){
            toReturn = last.element;
            last = last.prev;
            last.next = null;
            size--;
        }else {
            Node curPrev = findPrevNode(index);
            Node cur = curPrev.next;
            Node curNext = cur.next;
            curPrev.next = curNext;
            curNext.prev = curPrev;
            toReturn = cur.element;
            size--;
        }
        return toReturn;
    }

    @Override
    public boolean remove(Integer e) {
        if (head == null){
            throw new NullPointerException("链表为空，不能删除");
        }

        Node prev = null;

        for (Node cur = head; cur != null; prev = cur, cur = cur.next){
            if (cur.element.equals(e)){
                if (prev == null){
                    remove(0);
                }else {
                    prev.next = cur.next;
                    cur.next.prev = prev;
                    size--;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > this.size-1){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        if (head == null){
            throw new NullPointerException("链表为空");
        }
        if (index == 0){
            return head.element;
        }
        Node curPrev = findPrevNode(index);
        return curPrev.next.element;
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("不合法的下标" + index);
        }
        if (head == null) {
            throw new NullPointerException("链表为空");
        }
        Node node = new Node(e);

        int temp;
        if (index == 0) {
            temp = head.element;
            head.element = e;
        } else {
            Node curPrev = findPrevNode(index);
            curPrev = curPrev.next;
            temp = curPrev.element;
            curPrev.element = e;
        }
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head = null;  //一旦没有引用引用那个对象，它自动会被jvm回收掉
        last = null;  //last也要置空，因为它也引用着对象
        size = 0;  //最后别忘了把size置为0
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Integer e) {
        return false;
    }

    @Override
    public int indexOf(Integer e) {
        return 0;
    }

    @Override
    public int lastIndexOf(Integer e) {
        return 0;
    }

    @Override
    public MyIterator iterator() {
        return null;
    }
}
