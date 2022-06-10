package 算法.other;

import java.util.HashMap;
import java.util.Map;

public class Lc110_balanceTree {

    //记忆化搜索优化算法，
    // 将已经计算过的值存入集合，第二次访问直接从集合中取出来
    public boolean isBalanced(TreeNode root) {
         Map<TreeNode,Integer> heightMap = new HashMap<>();
        if (root == null) {
            return true;
        }
        int left = 0;
        int right = 0;
        //判断左树
        if (heightMap.containsKey(root.left)){
            //判断该节点的高度是否已经计算过了
            left =heightMap.get(root.left);
        }else {
            left =height(root.left);
            //将计算的值存入集合中
            heightMap.put(root.left,left);
        }
        //判断右树
        if (heightMap.containsKey(root.right)){
          right=  heightMap.get(root.right);
        }else {
            right =height(root.right);
            heightMap.put(root.right,right);
        }
        int abs = Math.abs(left - right);
        if (abs > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //求树高
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int max = Math.max(left, right);
        return 1 + max;
    }
}