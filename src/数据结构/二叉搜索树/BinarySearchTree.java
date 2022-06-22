package 数据结构.二叉搜索树;

/**
 * 基于整形的二分搜索树
 * jdk中的搜索树就是不存在相同的值TreeMap-key
 * 特性：中序遍历结果为升序集合
 *时间复杂度 logN
 */
public class BinarySearchTree {

    private class TreeNode{
        private int val;                     //节点值
        private TreeNode left;       //左子树
        private TreeNode right;     //右子树

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int size ;                  //节点个数
    private TreeNode root;          //根节点

    /**
     * 向二分搜索树中添加元素
     * @param val
     */
   public void add(int val){
       root=add(root,val);
   }

    /**
     * 向以root为根节点的二叉树中添加元素
     * @param root
     * @param val
     * @return
     */
   public TreeNode add(TreeNode root,int val){
       //创建新的节点
       TreeNode newNode =new TreeNode(val);
    if (root==null){
        //此时添加的元素就是根节点
        size++;
        return newNode;
    }
    if (root.val >val){
        //在左树中插入
        root.left =add(root.left,val);
    }
    if (root.val < val){
        //在右树中插入
        root.right =add(root.right,val);
    }
    return root;
   }
}
