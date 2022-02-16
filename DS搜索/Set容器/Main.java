package DS搜索.Set容器;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/16
 * Time: 20:31
 * Description: No Description
 */
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        System.out.println(set.add("apple"));
        System.out.println(set.add("peach"));
        System.out.println(set.add("banana"));
        System.out.println(set.add("orange"));

        System.out.println(set.size());
        System.out.println(set);

        System.out.println(set.add("apple"));
        System.out.println(set.contains("watermelon"));
        System.out.println(set.contains("apple"));

        System.out.println(set.remove("watermelon"));
        System.out.println(set.remove("apple"));
        System.out.println(set);

        set.clear();
        System.out.println(set.isEmpty());
        System.out.println(set.size());

        set.add("西瓜");
        set.add("冬瓜");
        set.add("南瓜");
        set.add("北瓜");
        set.add("地瓜");
        set.add("傻瓜");
        set.add("甜瓜");
        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}