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
     * 向以root为根节点的bst中添加元素，返回新的树根
     * @param root
     * @param val
     * @return
     */
   public TreeNode add(TreeNode root,int val){
    if (root==null){
        //创建新的节点
        TreeNode newNode =new TreeNode(val);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }
    /**
     * 先序遍历以root为根节点的BST，将节点值存到sb中
     * @param root
     * @param height
     * @param sb
     */
    private void generateBSTString(TreeNode root, int height, StringBuilder sb) {
        //边界条件
        if (root == null){
            sb.append(generateHeightStr(height)).append("NULL\n");
            return;
        }
        sb.append(generateHeightStr(height)).append(root.val).append("\n");
        //递归遍历左子树
        generateBSTString(root.left,height+1,sb);
        //递归遍历右子树
        generateBSTString(root.right,height+1,sb);
    }

    /**
     * 按照当前树所处的层次打印--
     * 每多一层，就多两个--
     * @param height
     * @return
     */
    private String generateHeightStr(int height) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

}
