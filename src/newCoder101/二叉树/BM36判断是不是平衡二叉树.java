package newCoder101.二叉树;

public class BM36判断是不是平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root ==null){
            return true;
        }
        //左树树高
        int left =height(root.left);
        int right =height(root.right);
        int abs=Math.abs(left-right);
        if (abs>1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 求树高
     * @param root
     * @return
     */
    private int height(TreeNode root) {
       if (root ==null){
           return 0;
       }
       int left=height(root.left);
       int right=height(root.right);
       return Math.max(left,right)+1;
    }
}
