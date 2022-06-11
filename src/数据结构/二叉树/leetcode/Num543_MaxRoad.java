package 数据结构.二叉树.leetcode;

/**
 * 求二叉树的最长直径
 */
public class Num543_MaxRoad {
    //最长路径
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //当为空树或者只有根节点时
    if (root == null || root.left ==null && root.right ==null){
        return 0;
    }
    height(root);
    return max;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        //递归计算左子树的高度
        int l=height(root.left);
        //递归计算右子树的高度
        int r = height(root.right);
        //在求树高的时候顺带计算左右子树的最长路径
        max = Math.max(max,(l+r));
        return 1+Math.max(l,r);             //返回值是当前以root为根节点的树的高度
    }
}
