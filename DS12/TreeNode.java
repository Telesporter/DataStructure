package DS12;


/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/25
 * Time: 22:01
 * Description: No Description
 */
public class TreeNode {
    public int v;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("TreeNode{v = %c}",v);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if(!(o instanceof TreeNode)){
            return false;
        }
        TreeNode treeNode = (TreeNode)o;
        return treeNode.v == this.v;
    }


}
