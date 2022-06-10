package 数据结构.二叉树.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历二叉树
 */
public class Num102_levelOrder {
    /**
     给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        //边界条件
        if (root == null){
            return ret;
        }
        //借助队列实现遍历过程
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);          //将根节点入队
        while (! deque.isEmpty() ){
            //使用tem数组保存当前层的所有元素
            List<Integer> curList =new ArrayList<>();
            //取出当前层所有的元素添加到curList中
            int size = deque.size();
            for (int i=0;i<size;i++){
                TreeNode cur =deque.poll();         //出队
                curList.add(cur.val);
                //判断当前层左右子树的是否为空
                if ( cur.left != null){
                    deque.offer(cur.left);  //入队
                }
                if(cur.right != null){
                    deque.offer(cur.right);
                }
            }
            //循环走完，当前层的所有元素都处理完，且下一层的元素都被保存到队列中去了
            ret.add(curList);
        }
        return ret;
    }
}
