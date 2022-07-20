package newCoder101.二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM23二叉树的前序遍历 {

    public int[] preorderTraversal (TreeNode root) {
        List<Integer> list =new ArrayList<>();
        preOrder(list,root);
        int[] ans =new int[list.size()];

        for (int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    //前序遍历
    private void preOrder(List<Integer> list, TreeNode root) {
        if (root ==null){
            return;
        }
        list.add(root.val);
        preOrder(list,root.left);
        preOrder(list,root.right);
    }
}
