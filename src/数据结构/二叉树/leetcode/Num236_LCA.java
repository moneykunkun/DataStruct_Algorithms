package 数据结构.二叉树.leetcode;

/**
 * 最近公共祖先问题
 */
public class Num236_LCA {
    private  TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //找到p和q的所有祖先
        findNode(root,p,q);
     return lca;
    }

    /**
     * 以root为根节点的树能否找到p或q
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null){
        return false;
    }
    //先在左树中寻找p/q
    int left = findNode(root.left,p,q) ?1:0;
    //再在右树中寻找p/q
    int right =findNode(root.right,p,q)?1:0;
   // 最后再判断根节点是否是p或q
    int mid = (root ==p || root ==q)?1:0;
    if (left+right+mid == 2){
        lca =root;
    }
    return (left +right+mid )>0;
    }
}
