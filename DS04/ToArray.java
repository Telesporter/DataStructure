package DataStructure.DS04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/10
 * Time: 16:02
 * Description: No Description
 */
public class ToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String[] strings = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
    }
}
