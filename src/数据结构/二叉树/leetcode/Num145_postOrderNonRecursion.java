package 数据结构.二叉树.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num145_postOrderNonRecursion {
    //二叉树的后序遍历，迭代方式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if ( root == null){
            return ret;
        }
        TreeNode cur = root;            //表示已经完全处理过的节点（左根右均已处理）
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while ( cur != null || !stack.isEmpty()){
            //先一路走到根节点
            while (cur !=null){
                stack.push(cur);
                cur= cur.left;
            }
            //此时左树为空，cur取栈顶元素，第二次访问
            cur = stack.pop();
            //接着判断右树是否为空 或者已经被我们访问过
            if ( cur.right ==null || prev ==cur.right){
                ret.add(cur.val);
                //当前节点cur就是最后处理的节点，更新prev引用，变为cur
                prev = cur;
                cur = null;
            }else {
                //此时右树不为空，且没有被处理过，继续把根节点压入栈中，继续处理右子树
                stack.push(cur);
                cur =cur.right;
            }
        }
        return ret;
    }
}
