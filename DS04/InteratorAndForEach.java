package DataStructure.DS04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/9
 * Time: 23:01
 * Description: No Description
 */
public class InteratorAndForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //两种写法等价
        for (String s : list) {
            System.out.println(s);
        }
    }
}
