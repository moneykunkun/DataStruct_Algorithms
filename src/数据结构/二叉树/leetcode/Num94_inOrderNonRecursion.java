package 数据结构.二叉树.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author qk
 * @date 2022/3/11 17:25
 * 二叉树的中序遍历
 * 非递归方式
 */
public class Num94_inOrderNonRecursion {
    //中序遍历的迭代写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        TreeNode cur = root;        //当前走到的节点
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null  ||  !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //此时cur为空，表示当前节点已经时叶子节点，栈顶元素就是当前节点的左孩子
            cur =stack.pop();
            ret.add(cur.val);
            //继续访问右子树
            cur = cur.right;
        }
        return ret;
    }
}
