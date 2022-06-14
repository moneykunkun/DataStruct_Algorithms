package 数据结构.二叉树.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一棵二叉搜索树的root，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 */
public class Num897_increasingBST {

    public TreeNode increasingBST(TreeNode root) {
         List<Integer> ret = new ArrayList<>();
        inorder(root,ret);
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode curNode=dummyNode;
        for (int val :ret){
            curNode.right=new TreeNode(val);
            curNode = curNode.right;
        }

        return dummyNode.right;
    }

    private void inorder(TreeNode root, List<Integer> ret) {
    if (root==null){
        return;
    }
    inorder(root.left,ret);
    ret.add(root.val);
    inorder(root.right,ret);
    }
}
