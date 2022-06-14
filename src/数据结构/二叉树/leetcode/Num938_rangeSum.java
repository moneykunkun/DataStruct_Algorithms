package 数据结构.二叉树.leetcode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *二叉搜索树：中序遍历结果是递增序列
 */
public class Num938_rangeSum {

  //根据二叉搜索树的特征 根节点的值大于左子树的值 小于右子树的值
    public int rangeSumBST(TreeNode root, int low, int high) {
        //如果根节点为空
        if (root ==null){
            return 0;
        }
        //根节点值大于high 返回左子树范围和
        if (root.val >high){
            return rangeSumBST(root.left,low,high);
        }
        //根节点值小于 low 返回右子树范围和
        if (root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        //根节点的值在[low,high]之间时，返回根节点的值加上左右子树节点值
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
