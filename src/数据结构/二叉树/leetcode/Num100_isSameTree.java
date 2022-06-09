package 数据结构.二叉树.leetcode;

/**
 * 传入两颗二叉树的根节点，判断两棵树是否是同一颗树
 */
public class Num100_isSameTree {

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
