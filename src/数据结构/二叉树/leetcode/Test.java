package 数据结构.二叉树.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque =new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()){
           TreeNode node1 = deque.poll();
           TreeNode node2 = deque.poll();

           if (node1==null && node2 ==null){
              continue;
           }
           if (node1==null || node2 ==null){
               return false;
           }
           if (node1.val != node2.val){
               return false;
           }
           //两个左右子树都不为空，继续判断node1.left和node2
            deque.offer(node1.left);
           deque.offer(node2.right);
           deque.offer(node1.right);
           deque.offer(node2.left);
        }
        return true;
    }

}
