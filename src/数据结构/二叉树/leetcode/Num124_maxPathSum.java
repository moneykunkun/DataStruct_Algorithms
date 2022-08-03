package 数据结构.二叉树.leetcode;

public class Num124_maxPathSum {
    //保存最大路径和的值
    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    /**
     * 深度优先遍历二叉树，找到二叉树中的最大路径和
     * @param root
     */
    private int dfs(TreeNode root) {
        if (root ==null) return 0;
        //递归求出左左右子树中的最大和
        int left=dfs(root.left);
        int right=dfs(root.right);
        //最大路径和分四种情况
        //1.根节点自己；2.根节点+左节点；3.根节点+右节点；
        int ret=Math.max(root.val,root.val+Math.max(left,right));
       // 4.根节点+左右子节点
        maxSum=Math.max(maxSum,Math.max(ret,root.val+left+right));
        return ret;
    }
}
