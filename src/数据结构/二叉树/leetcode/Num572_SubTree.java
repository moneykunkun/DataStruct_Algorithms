package 数据结构.二叉树.leetcode;

/**
 * 子树问题
 */
public class Num572_SubTree {
    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //边界条件
        //两颗树都是空树
        if( root == null && subRoot ==null){
            return true;
        }
        //两棵树其中有一颗是空树
        if (root ==null || subRoot == null){
            return false;
        }
        //root 和subTree 相同 || 左树包含 或者 右树包含
        return isSameTree(root,subRoot) || isSubtree(root.left,subRoot) ||isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //边界条件
        if(p == null && q ==null){
            //两棵树都是空树，相同
            return true;
        }
        //如果有一棵树为空，另一颗不为空
        if (p == null || q ==null){
            return false;
        }
        //判断两个根节点的值是否相同
        if (p.val != q.val){
            return false;
        }
        //此时，两棵树的根节点相同，则：
        //递归判断两棵树的左右节点
        return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
    }
}
