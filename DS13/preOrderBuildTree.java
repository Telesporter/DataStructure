package DS13;

import DS12.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/30
 * Time: 12:47
 * Description: No Description
 */
public class preOrderBuildTree {
    public static TreeNode preOrderBuildTree(String s){
        if (s.charAt(0) == '#'){
            return null;
        }
        TreeNode root = new TreeNode(s.charAt(0));
        TreeNode cur = root;
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            while (s.charAt(i) != '#'){
                TreeNode node = new TreeNode(s.charAt(i));
                cur.left = node;
                cur = node;
                queue.add(node);
                i++;
            }
            while (s.charAt(i) == '#'){

            }

        }
    }
}
