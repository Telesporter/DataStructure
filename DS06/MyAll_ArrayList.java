package DataStructure.DS06;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 15:47
 * Description: No Description
 */
public class MyAll_ArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    public MyAll_ArrayList() {
        // 无法直接定义泛型数组，所以只能定义 Object 类型的数组
        // 然后强转
        array = (E[])new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        throw new RuntimeException("不支持的方法");
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = array[i];
        }
        return a;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 创建一个数组直接返回
            T[] newArray = (T[])new Object[size];
            for (int i = 0; i < size; i++) {
                newArray[i] = (T) array[i];
            }
            return newArray;
        } else if (a.length == size) {
            // 把元素放入并返回
            for (int i = 0; i < size; i++) {
                a[i] = (T)array[i];
            }
            return a;
        } else {
            // 把元素放入并返回
            // 把超过的第一个位置设置成 null
            for (int i = 0; i < size; i++) {
                a[i] = (T)array[i];
            }
            a[size] = null;
            return a;
        }
    }

    @Override
    public boolean add(E e) {
        // TODO: 扩容没有考虑
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1) {
            return false;
        } else {
            remove(i);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public void clear() {
        // 如果是基本类型，数组中的元素是否要清理成无效值其实无所谓
        // 但如果是引用类型，必须把数组中的元素修改成 null
        // 这样才不会内存泄漏
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        // TODO: 下标
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        // TODO: 下标
        E e = array[index];
        array[index] = element;
        return e;
    }

    @Override
    public void add(int index, E element) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public E remove(int index) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public int indexOf(Object o) {
        // 泛型中，引用类型的处理
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (array[i] == o) {
                    return i;
                }
            } else {
                // 平时用 ArrayList 的 contains/indexOf 等，都会
                // 调用元素的 equals 方法
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new RuntimeException("暂时不实现");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new RuntimeException("暂时不实现");
    }
}
