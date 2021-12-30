package DS13;

import DS12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/30
 * Time: 8:46
 * Description: No Description
 */
public class IsComplete {
    public static boolean isComplete(TreeNode root){
        if (root == null){
            System.out.println("树为空");
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true){
            TreeNode node = queue.remove();
            if (node == null){  //如果遇到空结点
                while (node == null){  //把剩余的连着的空结点全部移除
                    node = queue.remove();
                }
                if (queue.isEmpty()){ //如果移完后发现队列为空，那就说明是完全二叉树
                    break;
                }else {  //否则还有别的元素，那就表明不是完全二叉树
                    return false;
                }
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return true;
    }
}
