package newCoder101.二叉树;

public class BM34判断是不是二叉搜索树 {

    //先定义一个最小值
    int min =Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if (root ==null){
            return true;
        }
        //先判断左树
        if (!isValidBST(root.left)){
            //左树为空
            return  false;
        }
        //左树不为空，判断当前节点的值和左子树节点值
        if (root.val <min){
            return false;
        }
        //根节点的值大于最小值，更新节点值
        min =root.val;
        //在递归访问右子树
        return isValidBST(root.right);
        }
    }

