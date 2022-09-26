package 剑指offer;

import java.util.ArrayList;

public class Offer54_二叉搜索树的第k大节点 {

    ArrayList<Integer> res =new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        //中序遍历二叉树
        inorderTravel(root);
       return res.get(res.size()-k);
    }

    //中序遍历二叉树
    private void inorderTravel(TreeNode root) {
        if (root ==null){
            return ;
        }
        inorderTravel(root.left);
        res.add(root.val);
        inorderTravel(root.right);
    }
}
