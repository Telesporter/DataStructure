package DataStructure.DS06;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/13
 * Time: 14:56
 * Description: 仿写真实的List
 * int表示下标
 * Integer表示元素
 */
public interface MyInt_List extends MyIterable {
    boolean add(Integer e);  //尾插
    void add(int index,Integer e);  //中间插

    Integer remove(int index);  //根据下标删除
    boolean remove(Integer e);  //删除第一个遇到的e

    Integer get(int index);
    Integer set(int index,Integer e);

    int size();


    void clear();
    boolean isEmpty();

    boolean contains(Integer e);
    int indexOf(Integer e);
    int lastIndexOf(Integer e);
}
