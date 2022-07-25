package newCoder101.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class BM35判断是不是完全二叉树 {

    /**
     * 解题思路：引入标记位区分二叉树的状态
     * 状态切换:    状态一：切换条件：1.当碰到第一个只有左树没有右树的节点；2.碰到第一个叶子节点
     *                    状态二:  位于状态二的节点全是叶子节点
     * @param root
     * @return
     */
    public boolean isCompleteTree (TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        //引入标记位
        boolean flag=false;

        while (!queue.isEmpty()){
            //取出队列中的元素
            TreeNode cur= queue.poll();
            if (!flag){
                //状态1,判断左右子树情况
                if (cur.left !=null && cur.right !=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.left !=null){
                    //只有左子树,切换状态
                    flag =true;
                    queue.offer(cur.left);
                }else if (cur.right !=null){
                    //只有右子树
                    return false;
                }else {
                    //只有一个节点
                    flag =true;
                }
            }else {
                //状态2，所有子树都必须时叶子节点
                if (cur.left !=null || cur.right !=null){
                    return false;
                }
            }
        }
        return true;
    }
}
