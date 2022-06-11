package 数据结构.二叉树.leetcode;


public class Num606_Tree2Str {
    /**
     *传入一个以root 为根节点的二叉树，以前序遍历的方式将二叉树转为字符串
     * @param root
     * @return
     */
    StringBuilder sb=new StringBuilder();
    public String tree2str(TreeNode root) {
        //边界条件
        if (root == null){
            return "";
        }
        //先访问根节点，直接将根节点的值凭借到字符串
        sb.append(root.val);
        //递归遍历左子树
        if (root.left != null){
            sb.append("(");
            //递归拼接左子树的节点值
            tree2str(root.left);
            sb.append(")");
        }else {
            //左子树为空时，再去看右子树的情况
            if ( root.right !=null){
                sb.append("()");
            }
        }
        //再去遍历右子树
        if (root.right != null){
            sb.append("(");
            tree2str(root.right);
            sb.append(")");
        }
        return sb.toString();
    }
}
