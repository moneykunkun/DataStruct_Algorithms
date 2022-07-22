package newCoder101.二叉树;

public class BM33二叉树的镜像 {

    /**
     * 给定一颗二叉树，将其转为二叉树的镜像
     * @param pRoot
     * @return
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot ==null){
            return null;
        }
        //先递归左子树
        TreeNode left =Mirror(pRoot.left);
        TreeNode right=Mirror(pRoot.right);
        //交换
        pRoot.right =left;
        pRoot.left =right;
        return pRoot;
    }
}
