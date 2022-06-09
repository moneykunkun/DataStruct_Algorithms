package 数据结构.二叉树.leetcode;
//合并两颗二叉树
//解题思路：分三种情况：二叉树的两个节点都为空，合并后返回空
//                                        一棵树为空，另一颗不为空，合并后返回不为空节点
//                                        两棵树都不为空，将两棵树的节点值相加作为新节点的值     递归
public class Num617_mergeTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode newNode = new TreeNode(root1.val+root2.val);
        newNode.left=mergeTrees(root1.left,root2.left);
        newNode.right =mergeTrees(root1.right,root2.right);
        return newNode;
    }

}
