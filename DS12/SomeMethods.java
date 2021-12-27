package DS12;




/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/27
 * Time: 14:49
 * Description: No Description
 */
public class SomeMethods {
    public static TreeNode contains3(TreeNode root,TreeNode node){
        if (root == null){
            return null;
        }else if (root.equals(node)){
            return root;
        }else {
            if (contains3(root.left,node) != null){
                return contains3(root.left,node);
            }else {
                return contains3(root.right,node);
            }
        }
    }




    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree();
        TreeNode node = new TreeNode('Z');
        System.out.println(contains3(root,node));
    }
    
}
