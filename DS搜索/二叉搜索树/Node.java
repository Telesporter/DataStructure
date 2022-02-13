package DS搜索.二叉搜索树;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/13
 * Time: 21:02
 * Description: No Description
 */
public class Node {
    public Integer key;
    public Node left;
    public Node right;

    public Node(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
