package 数据结构.二叉树.leetcode;
// 二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
//https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
public class NowCoder_JZ36 {

    //将二叉树转为双向链表

    /**
     * 传入以pRootOfTree为根节点的平衡二叉树，转为双向链表
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        //边界条件
        if(pRootOfTree ==null){
            return null;
        }
        //对树进行中序遍历
        //此时的遍历就是先将左子树转为双向链表，leftHead就是左链表的头节点
        TreeNode leftHead =Convert(pRootOfTree.left);
        //从头结点开始，找到左链表的尾节点，挂载根节点
        TreeNode leftTail =leftHead;
        while (leftTail !=null && leftTail.right !=null){
            leftTail=leftTail.right;
        }
        //此时，leftTail就处在左链表的尾戒点，拼接根节点
        if (leftTail !=null){
            pRootOfTree.left=leftTail;
            leftTail.right=pRootOfTree;
        }
        //再递归处理右子树，转换右子树为双向链表，返回右侧链表的头节点
        TreeNode rightHead =Convert(pRootOfTree.right);
        if (rightHead !=null){
            pRootOfTree.right=rightHead;
            rightHead.left =pRootOfTree;
        }
        //二叉树的中序遍历结束，返回整个链表的根节点
        //两种情况，左子树不为空，返回左链表的头节点，左子树为空则返回根节点
        return  leftHead ==null ?pRootOfTree:leftHead;
    }

}
