package 剑指offer;

import java.util.*;

public class Offer32_从上到下打印二叉树II {

    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list =new ArrayList<>();
            if (root ==null) {
                return list;
            }
            Queue<TreeNode> queue =new LinkedList<>();
            //先将根节点入队
            queue.offer(root);
            while (!queue.isEmpty()){
                List<Integer> ret =new ArrayList<>();
                int size= queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node =queue.poll();
                    ret.add(node.val);
                    if (node.left !=null){
                        queue.offer(node.left);
                    }
                    if (node.right !=null){
                        queue.offer(node.right);
                    }
                }
                list.add(ret);
            }
            return list;
    }
}
