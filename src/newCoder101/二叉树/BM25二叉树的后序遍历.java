package newCoder101.二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM25二叉树的后序遍历 {

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list =new ArrayList<>();
        postOrder(list,root);
        int[] ans =new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] =list.get(i);
        }
        return ans;
    }

    private void postOrder(List<Integer> list, TreeNode root) {
        if (root ==null) {
            return;
        }
        postOrder(list,root.left);
        postOrder(list,root.right);
        list.add(root.val);
    }
}
