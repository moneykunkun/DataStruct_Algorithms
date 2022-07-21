package newCoder101.二叉树;

import java.util.Stack;

public class BM29二叉树中和为某一值的路径 {

    /**
     * 递归写法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root ==null){
            return false;
        }
        if (root.left ==null && root.right ==null && sum-root.val==0){
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum- root.val);
    }

    /**
     * 非递归写法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumNonRecursion (TreeNode root, int sum) {
        if (root ==null){
            return false;
        }
        //存储节值的栈
        Stack<TreeNode> stack1 =new Stack<>();
        //存储节点值的栈
        Stack<Integer> stack2 =new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        //取出stack
        while (!stack1.isEmpty()){
            TreeNode tmp =stack1.pop();
            int num=stack2.pop();
            if (tmp.left ==null && tmp.right ==null && num ==sum){
                return true;
            }
            if (tmp.left !=null){
                stack1.push(tmp.left);
                stack2.push(tmp.left.val+num);
            }
            if (tmp.right!=null){
                stack1.push(tmp.right);
                stack2.push(tmp.right.val+num);
            }
        }
        return false;

    }
}
