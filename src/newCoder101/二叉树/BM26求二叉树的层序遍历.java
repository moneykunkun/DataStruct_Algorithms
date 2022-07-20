package newCoder101.二叉树;

import java.util.*;

public class BM26求二叉树的层序遍历 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        if (root ==null){
            return ans;
        }
        //借助队列实现遍历
        Deque<TreeNode> deque =new LinkedList<>();
        //先将根节点入队
        deque.offer(root);
        while (!deque.isEmpty()){
            //保存当前层的数据
            ArrayList<Integer> cur =new ArrayList<>();
            //取出当前层的所有元素添加到cur中
            int size =deque.size();
            for (int i = 0; i < size; i++) {
                //先将队列的元素取出添加到集合中
                TreeNode node =deque.poll();
                cur.add(node.val);
                //再处理左右子树问题
                if (node.left !=null){
                    deque.offer(node.left);
                }
                if (node.right !=null){
                    deque.offer(node.right);
                }
            }
            //循环走完，当前层的元素都被添加进cur中
            ans.add(cur);
        }
        return ans;
    }
}
