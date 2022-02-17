package DS搜索.二叉搜索树;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/13
 * Time: 23:12
 * Description: No Description
 */
public class TestCase {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(9);
        tree.insert(6);
        tree.insert(8);
        tree.insert(7);
        tree.insert(0);
        tree.insert(2);
        tree.remove(2);
        System.out.println("hello");
        for (int i = -1; i < 10; i++) {
            System.out.println(i+":找到没"+tree.search(i));
        }
    }
}
