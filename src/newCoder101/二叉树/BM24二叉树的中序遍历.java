package newCoder101.二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM24二叉树的中序遍历 {
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list =new ArrayList<>();
        inorder(list,root);
        int[] ans =new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]= list.get(i);
        }
        return ans;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root ==null) {
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}
