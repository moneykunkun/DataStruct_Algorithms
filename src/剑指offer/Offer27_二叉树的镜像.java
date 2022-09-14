package 剑指offer;

public class Offer27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return root;
        }
        TreeNode left =mirrorTree(root.left);
        TreeNode right =mirrorTree(root.right);
        root.left =right;
        root.right =left;
        return root;
    }
}
