package DataStructure.DS02;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/7
 * Time: 19:26
 * Description: No Description
 */
public class comparatorByAge implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.age - o2.age;
    }
}
