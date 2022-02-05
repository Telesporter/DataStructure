package DS堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/1/28
 * Time: 23:14
 * Description: No Description
 */
public class 优先队列Person类 {
    public static void main2(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -o1.name.compareTo(o2.name);
            }
        });
        Person p1 = new Person("gaobo", 18);
        Person p2 = new Person("chenpeixin", 30);
        Person p3 = new Person("tangzhong", 28);
        Person p4 = new Person("xuzhichen", 16);

        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);

        System.out.println(queue.remove());
    }
}
