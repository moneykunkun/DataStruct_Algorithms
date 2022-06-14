package 数据结构.二叉树.leetcode;

public class Num236_lowestCommonAncestor {
    /**
     * 找到公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    //最近公共祖先
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //查找最近公共祖先
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        //root为空
        if (root ==null){
            return false;
        }
        //用整型变量记录是否找到节点
        //在左树中找p、q
        int left=findNode(root.left,p,q) ?1:0;              //找到返回1
        //再在右子树中找p或者q，找到一个就返回1
        int right=findNode(root.right,p,q) ?1:0;
        //最后在根节点判断是否是p或者q
        int mid =(root==p || root==q)?1:0;
        if (left+mid+right==2){
            lca=root;
        }
        return (left+mid+right)>0;
    }
}
