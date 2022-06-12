package 数据结构.二叉树.leetcode;

import java.util.Scanner;

/**
 * 牛客网二叉树的遍历
 * 连接：https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=40&&tqId=21342
 * 根据二叉树的前序遍历字符串，构建二叉树，返回二叉树的中序遍历结果
 */
public class NowCoder_KY11 {
    //节点内部类
    private static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {
        }
        public TreeNode(char val) {
            this.val = val;
        }
    }
    //表示当前遍历处理到哪个字符
    private static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //多组输入
        while (scanner.hasNext()){
            String str = scanner.next();
            //根据前序遍历的结果构建二叉树
            TreeNode root = preOrderStr(str);
            //中序遍历二叉树,输出节点值
                inOrder(root);
            System.out.println();
        }
    }

    /**
     * 传入二叉树的根节点，中序遍历二叉树
     * @param root
     */
    private static void inOrder(TreeNode root) {
        if (root == null){
            return;
        }
        //先递归遍历左子树
        inOrder(root.left);
        //再访问根节点
        System.out.print(root.val+" ");
        //递归遍历二叉树的右子树
        inOrder(root.right);
    }

    private static TreeNode preOrderStr(String str) {
        //取出字符串的每个字符
        char cur = str.charAt(index);
        if ( cur=='#'){
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;        //继续访问下一个字符
        //递归处理左子树
        root.left = preOrderStr(str);
        index++;
        //递归处理右子树
        root.right = preOrderStr(str);
        return root;
    }
}
