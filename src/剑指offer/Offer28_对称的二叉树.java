package 剑指offer;

public class Offer28_对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root ==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    /**
     * 判断两颗二叉树是否是镜像
     * @param left
     * @param right
     * @return
     */
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left ==null && right ==null){
            return true;
        }
        if (left ==null || right ==null){
            return false;
        }
        if (left.val !=right.val){
            return false;
        }
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
