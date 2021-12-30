package DS13;

import DS12.BuildTree;
import DS12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/29
 * Time: 14:33
 * Description: No Description
 */
public class CengXuBianLi {
    public static void commonOrder(TreeNode root){
        if (root == null){
            System.out.println("树为空");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree();
        commonOrder(root);
        System.out.println(IsComplete.isComplete(root));
    }
}
