package newCoder101.二叉树;

public class BM29二叉树中和为某一值的路径 {

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root ==null){
            return false;
        }
        if (root.left ==null && root.right ==null && sum-root.val==0){
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum- root.val);
    }
}
