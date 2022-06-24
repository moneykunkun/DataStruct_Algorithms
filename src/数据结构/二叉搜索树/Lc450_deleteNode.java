package 数据结构.二叉搜索树;



public class Lc450_deleteNode {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode deleteNode(TreeNode root, int key) {
            //边界值
        if(root ==null){
            return null;
        }
        if (key <root.val){
            //再左树中删除
            root.left =deleteNode(root.left, key);
        }else if (key > root.val){
            //在右树中删除
            root.right =deleteNode(root.right, root.val);
        }else {
            //此时，根节点就是待删除的节点
            //分三种清苦那个讨论
            if (root.left ==null){
                //只有右孩子
                return root.right;
            }
            if (root.right ==null){
                //只有左孩子
                return root.left;
            }
            //此时，待删除的根节点，左右子树的都不为空
            TreeNode node =root.right;
            //遍历node
            while (node.left !=null){
                node =node.left;
            }
            //此时，node就是root右子树的最左侧节点
            node .left =root.left;
            //将根节点置为root.right
            root =root.right;
        }
        return root;
    }
}
