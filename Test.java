package DataStructure;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/1
 * Time: 21:10
 * Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        String str = new String("abc");
        String str2 = new String("abc");
        Teacher t1 = new Teacher("gao");
        Teacher t2 = new Teacher("gao");
        Teacher t3 = new Teacher("mao");

        boolean ans1 = t1.equals(t2);
        boolean ans2 = t1.equals(t3);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
class Teacher{
    String name;
    public Teacher(String name) {
        this.name = name;
    }
}