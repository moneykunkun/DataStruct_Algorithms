package newCoder101.二叉树;

public class BM37二叉搜索树的最近公共祖先 {

    //最终返回的最近公共祖先节点
    private TreeNode lca;
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        findNode(root,p,q);
        return lca.val;
    }
    /**
     * 在以root为根节点的二叉树中找到p、q的公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean findNode(TreeNode root, int p, int q) {
        if (root ==null) {
            return false;
        }
        //在左树中查找，找到则返回1否则返回0
        int left=findNode(root.left,p,q)?1:0;
        //在右树中查找，找到则返回1否则返回0
        int right=findNode(root.right,p,q)?1:0;
        //在根节点查找
        int mid =(root.val ==p || root.val ==q)?1:0;
        if (left+right+mid ==2){
            lca =root;
        }
        return (left+right+mid) >0;
    }
}
