package newCoder101.二叉树;

public class BM31对称的二叉树 {
    /**
     * 给定一颗二叉树，判断其是否时对称的
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot ==null){
            return true;
        }
        return isMirror(pRoot.left,pRoot.right);
    }

    /**
     * 判断两颗二叉树是都时镜像
     * @param left
     * @param right
     * @return
     */
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left ==null && right ==null){
            //两棵树都为空
            return true;
        }
        if (left ==null || right ==null){
            //有一棵树为空
            return  false;
        }
        if (left.val != right.val){
            //两棵树的节点值不同
            return false;
        }
        //判断左树的左子树和右树的右子树是否相等，左树的右和右树的左是都相等
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
