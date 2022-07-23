package newCoder101.二叉树;

public class BM32合并二叉树 {

    /**
     * 合并二叉树
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        TreeNode newHead =new TreeNode(t1.val+t2.val);
        newHead.left=mergeTrees(t1.left,t2.left);
        newHead.right=mergeTrees(t1.right,t2.right);
        return newHead;
    }
}
