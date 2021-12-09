package DataStructure.DS04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/9
 * Time: 17:12
 * Description: No Description
 */
public class ListSearchIndex {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        Teacher t1 = new Teacher("1","Zebra");
        Teacher t2 = new Teacher("1","pig");
        teachers.add(t1);
        System.out.println(teachers.contains(t2));
        System.out.println(teachers.indexOf(t2));
    }
}
