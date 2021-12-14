package DataStructure.DS06;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 14:43
 * Description: No Description
 */
public class MyInt_ArrayList_Iterator implements MyIterator{
    //对一个顺序表做迭代，关键是控制下标
    private int index;  //我们在顺序表的哪个位置
    private MyInt_ArrayList list;  //我们要遍历的顺序表

    public MyInt_ArrayList_Iterator(MyInt_ArrayList list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }

    @Override
    public Integer next() {
        int temp = this.list.get(index);
        this.index++;
        return temp;
    }

    @Override
    public void remove() {
        this.list.remove(index-1);
    }
}
