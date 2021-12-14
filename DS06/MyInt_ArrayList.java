package DataStructure.DS06;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/13
 * Time: 17:47
 * Description: 仿写真实的ArrayList
 */
public class MyInt_ArrayList implements MyInt_List,MyIterable {
    private int[] array;  //顺序表内部数组
    private int size;  //顺序表的元素个数

    public MyInt_ArrayList() {
        this.array = new int[10];
        this.size = 0;
    }

    public MyInt_ArrayList(MyInt_List anOther) {
        this.array = new int[anOther.size()];
        for (int i = 0; i < anOther.size(); i++) {
            this.array[i] = anOther.get(i);
        }
        this.size = anOther.size();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i = 0; i < this.size; i++) {
            stringBuffer.append(this.array[i]);
            if (i != this.size-1){
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    //平均事件复杂度是O(1)
    //碰到需要扩容了，时间复杂度是O(n)
    //由于扩容的情况比较少见，所以，这个方法的时间复杂度一般被称为 平均O(1)
    @Override
    public boolean add(Integer e) {
        if (this.size == this.array.length){  //扩容
            ensureCapacity(this.size * 2);
        }
        this.array[this.size++] = e;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        if (index < 0||index > this.size){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        if (this.size == this.array.length){  //扩容
            ensureCapacity(this.size * 2);
        }
        for (int i = size; i > index; i--) {
            this.array[i] = this.array[i-1];
        }
        this.array[index] = e;
        this.size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > this.size-1){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        int temp = this.array[index];
        for (int i = index; i < this.size; i++) {
            this.array[i] = this.array[i+1];
        }
        this.size--;
        return temp;
    }

    @Override
    public boolean remove(Integer e) {
        int index = this.indexOf(e);
        if (index != -1){
            remove(index);
            this.size--;
            return true;
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > this.size-1){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        return this.array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index < 0 || index > this.size-1){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
        }
        int temp = this.array[index];
        this.array[index] = e;
        return temp;
    }

    @Override
    public int size() {
        return this.size;
    }



    @Override
    public void clear() {
        Arrays.fill(this.array,-1);
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Integer e) {
        return this.indexOf(e) != -1;
    }

    @Override
    public int indexOf(Integer e) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i = this.size-1; i >= 0; i++) {
            if (this.array[i] == e){
                return i;
            }
        }
        return 0;
    }

    //调用完这个方法以后，保证容量是大于等于capacity的
    //时间复杂度为O(n)
    public void ensureCapacity(int capacity){
        //0.检查是否需要扩容
        if (this.array.length > capacity){
            return;
        }
        //1.定义新的数组
        int[] newArray = new int[capacity];
        //2.进行搬家，从array数组中搬运到newArray中
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        //3.关联新的newArray
        this.array = newArray;
    }

    @Override
    public MyIterator iterator() {
        return new MyInt_ArrayList_Iterator(this);
    }
}
