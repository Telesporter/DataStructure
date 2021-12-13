package DataStructure.DS06;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/13
 * Time: 17:47
 * Description: 仿写真实的ArrayList
 */
public class myInt_ArrayList implements myInt_List {
    private int[] array;  //顺序表内部数组
    private int size;  //顺序表的元素个数

    public myInt_ArrayList() {
        this.array = new int[10];
        this.size = 0;
    }

    public myInt_ArrayList(myInt_List anOther) {
    }

    @Override
    public boolean add(Integer e) {
        this.array[this.size++] = e;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        // TODO: 2021/12/13  扩容留着后面写
        if (index < 0||index > this.size){
            throw new IndexOutOfBoundsException("不合法的下标"+index);
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

}
