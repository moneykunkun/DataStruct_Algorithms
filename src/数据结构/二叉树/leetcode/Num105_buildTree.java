package 数据结构.二叉树.leetcode;

/**
 * 从前序遍历和中序遍历结果中构建二叉树
 */
public class Num105_buildTree {
    /**
     * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历，
     * inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * @param preorder
     * @param inorder
     * @return
     */
    private int index = 0;      //处理到前序结果集的节点位置
    public TreeNode buildTree(int[ ] preorder, int[ ] inorder) {
    return  buildTreeHelper(preorder,inorder,0,preorder.length-1);
    }

    /**
     * 在preOrder的 [left,right] 区间借助中序遍历还原二叉树
     * @param preorder
     * @param left
     * @param inorder
     * @param right
     * @return 二叉树的根节点
     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        //边界条件
        if (left > right){
            //空区间
            return null;
        }
        if ( index ==preorder.length){          //表示前序遍历已经全部处理完毕
            return null;
        }
        //构建根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //找到该节点在中序遍历中的位置
        int pos = find(root.val,inorder);
        //根据中序位置找到左右子树
        root.left = buildTreeHelper(preorder,inorder,left,pos-1);
        root.right = buildTreeHelper(preorder,inorder,pos+1,right);
        return root;
    }

    /**
     * 找到val在中序遍历中的位置
     * @param val
     * @param inorder
     * @return
     */
    private int find(int val, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            if (inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
