package 数据结构.二叉树.leetcode;

/**
 * @author qk
 * @date 2022年03月02日 16:42
 * 牛客网二叉搜索树转换为双向链表
 * 二叉搜索树BST：二叉搜索树的中序遍历会得到一个递增序列
 *
 * https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5
 */
public class NowCoder_convertTree {

 /**
  * 传入一个以pRoot为根节点的BST，转为双向链表，并返回链表的头节点
  * 中序遍历二叉树：左-根-右
  * @date 2022/3/2 16:45
  */
    public TreeNode Convert(TreeNode pRootOfTree) {
    //1.先判断该树是否为空
        if (pRootOfTree == null){
        return null;
    }
        //2.中序遍历二叉树，遍历的过程中先将左子树转化为双向链表
        //此时，leftHead就是左链表的头节点
        TreeNode leftHead = Convert(pRootOfTree.left);
        //3.继续处理根节点，左子树的尾节点要链接再根节点
        //找到左链表的尾节点
        TreeNode leftTail = leftHead;
        //注意判空
        while (leftTail != null && leftTail.right !=null){
            leftTail = leftTail.right;
        }
        //此时leftTail就是左侧链表的尾节点，将尾节点挂接到根节点
        if ( leftTail != null){
            pRootOfTree.left = leftTail;
            leftTail.right =pRootOfTree;
        }
        //4.递归处理右子树
        TreeNode rightHead = Convert(pRootOfTree.right);
        //将右子树的头节点和根节点拼接
        if (rightHead != null){
            pRootOfTree.right =rightHead;
            rightHead.left = pRootOfTree;
        }
        //5.整棵树走完，返回根节点，分两种情况：左树不为空时，返回左子树的头节点，否则返回根节点
        return leftHead ==null ? pRootOfTree:leftHead;
    }
}
