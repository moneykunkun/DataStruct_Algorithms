package 剑指offer;

public class Offer55_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        //空树
        if (root==null){
            return true;
        }
        //计算左右子树得树高
        int left =height(root.left);
        int right=height(root.right);
        //计算左右子树树高得差值
        int abs =Math.abs(left-right);
        if (abs>1){
            return false;
        }
        //判断左右子树是否是平衡
    return isBalanced(root.left) && isBalanced(root.right);
    }
    //计算树高
    private int height(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return 1+Math.max(left,right);
    }
}
