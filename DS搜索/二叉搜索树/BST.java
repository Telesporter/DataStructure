package DS搜索.二叉搜索树;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/13
 * Time: 21:04
 * Description: No Description
 */
public class BST {
    private Node root;
    public boolean search(Integer key){
        Node current = this.root;
        while (current != null){
            int cmp = key.compareTo(current.key);
            if (cmp == 0){
                return true;
            }else if (cmp < 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(Integer key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        // 始终保持 parent 就是 current 的双亲节点
        Node parent = null;
        Node current = root;

        int cmp = 0;
        while (current != null) {
            cmp = key.compareTo(current.key);
            if (cmp == 0) {
                throw new RuntimeException("BST 中不允许出现相同的 key");
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        // current 一定 null。
        // parent 就是要插入新节点的双亲节点
        Node node = new Node(key);
        if (cmp < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }
    public boolean remove(Integer key) {
        // 1. 查找要删除的 key 所在的节点，记作 node。node 的双亲节点，记作 parent
        Node parent = null;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                removeInternal(current, parent);
                return true;
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        return false;
    }

    private void removeInternal(Node node, Node parent) {
        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
            } else if (node == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (node.left != null && node.right == null) {
            if (node == root) {
                root = node.left;
            } else if (node == parent.left) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if (node.left == null && node.right != null) {
            if (node == root) {
                root = node.right;
            } else if (node == parent.left) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {
            // 使用替换法删除，使用 node 的左子树中的最大值所在的节点，记作 ghost。ghost 的双亲记作 ghostParent
            Node ghostParent = node;
            Node ghost = node.left;
            // 一路朝右查找，直到 ghost.right == null
            while (ghost.right != null) {
                ghostParent = ghost;
                ghost = ghost.right;
            }

            //这里的ghost一定没有右子树
            // 1. 替换
            node.key = ghost.key;
            // 2. 删除 ghost 节点（其右孩子一定是 null)
            if (node == ghostParent) {
                //删除点即为左子树最大点的双亲，只有这种情况，ghost才有可能为ghostParent的左子树
                //这种情况就是node的左孩子没有右孩子
                ghostParent.left = ghost.left;
            } else {
                //否则，ghost一定是ghostParent右子树
                //这种情况就是node的右孩子没有左孩子
                ghostParent.right = ghost.left;
            }
        }
    }
}
