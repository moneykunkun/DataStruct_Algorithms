package 数据结构.二叉树.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**求二叉树的最大宽度
 * @author qk
 * @date 2022年03月11日 9:45
 */
public class Num662_bigWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if ( root == null){
            return 0;
        }
        int maxWidth = 0;
        Queue<NumNode> queue =new LinkedList<>();
        queue.offer(new NumNode(root,1));
        while (!queue.isEmpty()){
            int levelWidth = 0;              //当前层的最大宽度
            int size = queue.size();        //当前队列中元素的个数
            int R =0;                              //最右侧节点编号
            int L = 0;                              //最左侧节点编号
            for (int i = 0; i < size; i++) {
                NumNode cur  = queue.poll();
                if (i==0 ){
                    // cur就是左侧节点的编号
                    L = cur.num;
                }
                if (i == size-1){
                    //cur就是最右侧节点的编号
                    R =cur.num;
                }
                if ( cur.node.left !=null){
                    queue.offer(new NumNode(cur.node.left,cur.num *2));
                }
                if (cur.node.right != null){
                    queue.offer(new NumNode(cur.node.right,cur.num*2+1));
                }
            }
            levelWidth = R-L +1;
            maxWidth = Math.max(levelWidth,maxWidth);
        }
        return maxWidth;
    }

    //在层序遍历的过程中，存储每个出现的节点和它的编号
    private class NumNode{
        TreeNode node;
        int num;    //存储的节点编号

        public NumNode(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
