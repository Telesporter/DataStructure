package DS11;


/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/25
 * Time: 21:55
 * Description: No Description
 */
public class SomeMethod {
    public static int myGetNodeCount(TreeNode root){  //返回树中结点的个数
        if (root != null){
            return myGetNodeCount(root.left)+myGetNodeCount(root.right)+1;
        }else {
            return 0;
        }
    }
    public static int getLevelsAmount(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return getLevelsAmount(root.left)+getLevelsAmount(root.right);
    }

//    private static int n = 0;
//    public static int TeacherGetNodeCount(TreeNode root){
//        n = 0;
//        preOrder(root);
//        return n;
//    }
//
//    private static void preOrder(TreeNode root) {
//        if (root != null){
//            n++;
//            preOrder(root.left);
//            preOrder(root.right);
//        }
//    }

//    static int count = 0;
//    public static int getKNodeCount(TreeNode root,int k){
//        count = 0;
//        preOrder(root,k);
//        return count;
//    }
//    public static void preOrder(TreeNode root,int k){
//        if (root != null){
//            if (k == 1){
//                count++;
//            }
//            preOrder(root.left,k-1);
//            preOrder(root.right,k-1);
//        }
//    }
    public static int getKNodeCount(TreeNode root,int k){
        if (root == null){
            return 0;
        }else if (k == 1){
            return 1;
        }else {
            return getKNodeCount(root.left,k-1)+getKNodeCount(root.right,k-1);
            //一棵树的k层的结点就等于整棵树左子树第k-1层的结点个数+右子树第k-1层的结点个数
        }
    }

    public static int getTreeHeight(TreeNode root){
        if (root == null){
            return 0;
        } else{
            int left = getTreeHeight(root.left);
            int right = getTreeHeight(root.right);
            return Math.max(left, right)+1;
        }
    }
    public static boolean contains(TreeNode root,int v){
        if (root == null){
            return false;
        }else if (root.v == v){
            return true;
        }else {
            return contains(root.left,v)||contains(root.right,v);
        }
    }

    public static TreeNode contains2(TreeNode root,int v){
        if (root == null){
            return null;
        }else if (root.v == v){
            return root;
        }else {
            if (contains2(root.left,v) == null){
                return contains2(root.right,v);
            }else {
                return contains2(root.left,v);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree();
        System.out.println(myGetNodeCount(root));
        System.out.println(getLevelsAmount(root));
        System.out.println(getKNodeCount(root,3));
        System.out.println(getTreeHeight(root));
        System.out.println(contains(root,'G'));

        System.out.println(contains2(root,'Z'));  //null
        System.out.printf("%c",contains2(root,'Z').v);  //空指针异常

//        System.out.println(TeacherGetNodeCount(root));
    }
}
