package 剑指offer;

public class Offer07_重建二叉树 {

    private int index =0;           //表示处理前序遍历的索引位置
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,0,preorder.length-1);
    }

    /**
     * 根据前序遍历和总序遍历构建二叉树的辅助类
     * @param preorder
     * @param inorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        //边界条件
        if (left>right){
            return  null;
        }
        //表示前序结果以及全部处理完
        if (index ==preorder.length){
            return null;
        }
        //构建二叉树 的头节点
        TreeNode root =new TreeNode(preorder[index]);
        index++;
        //在中序遍历中找到root的位置
        int pos =findNode(inorder,root.val);
        root.left =buildTreeHelper(preorder,inorder,left,pos-1);
        root.right =buildTreeHelper(preorder,inorder,pos+1,right);
        return root;
    }

    private int findNode(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] ==val){
                return i;
            }
        }
        return -1;
    }
}
