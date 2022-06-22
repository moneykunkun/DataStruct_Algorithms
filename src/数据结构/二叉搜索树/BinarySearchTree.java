package 数据结构.二叉搜索树;


import java.util.NoSuchElementException;

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

   public boolean contains(int val){
       return contains(root,val);
   }

    /**
     * 判断以root为根节点的bst中是否包含val
     * @param root
     * @param val
     * @return
     */
    private boolean contains(TreeNode root, int val) {
        if (root==null){
            return false;
        }
        //根节点恰好值为val
        if (root.val ==val) {
            return true;
        }else if (val <root.val){
            //在左树中查找
            return contains(root.left,val);
        }else {
            //在右树中查找
            return contains(root.right,val);
        }
    }

    /**
     * 查找bst中的最小值
     * @return
     */
    public int findMin(){
        //判空
        if(size==0){
            //空树
        throw new NoSuchElementException("bst is empty!");
        }
        //最小值节点
        TreeNode minNode =minNode(root);
        return minNode.val;
    }

    /**
     * 在以root为根节点的bst中查找最小值节点
     * 思路：bst最小值，左树空，min=root，否则一直递归左子树
     * @param root
     * @return
     */
    private TreeNode minNode(TreeNode root) {
        if (root.left==null){
            //左树为空，最小值就是根节点
            return root;
        }
        //左树不为空，一路向左左子树
        return minNode(root.left);
    }

    /**
     * 删除bst中的最小值，返回删除的节点值
     * @return
     */
    public int removeMin(){
        int min =findMin();
        root=removeMin(root);
        return min;
    }

    /**
     * 在以root为根节点的bst中删除最小值
     * @param root
     * @return
     */
    private TreeNode removeMin(TreeNode root) {
        if (root.left ==null){
            //此时，根节点就是待删除的节点值,暂存一下右子树
            TreeNode right =root.right;
            //断开根节点
            root.right =root =null;
            size--;
            return right;
        }
        //左树不为空，再递归去左树中删除
        root.left= removeMin(root.left);
        return root;
    }

    /**
     * 查找bst中的最大值
     * @return
     */
    public int findMax(){
        //判空
        if(size==0){
            //空树
            throw new NoSuchElementException("bst is empty!");
        }
        TreeNode maxNode =maxNode(root);
        return maxNode.val;
    }

    /**
     * 在以root为根节点的bst中查找最大值节点
     * 思路：bst最大值，右树空，max=root，否则一直递归右子树
     * @param root
     * @return
     */
    private TreeNode maxNode(TreeNode root) {
        if (root.right==null){
            //右树为空，最大值就是根节点
            return root;
        }
        //右树不为空，一路向右，右子树
        return maxNode(root.right);
    }


    /**
     * 删除bst中的最大值，返回最大值
     * @return
     */
        public int removeMax(){
        int max =findMax();
        root =removeMax(root);
        return max;
        }

    /**
     * 删除以root为根节点的bst中查找最大值节点
     * 思路：bst最大值，右树空，max=root，否则一直递归右子树
     * @param root
     * @return
     */
    private TreeNode removeMax(TreeNode root) {
        if (root.right==null){
            //右树为空，根节点就是最大值
            TreeNode left =root.left;
            root.left=root=null;
            size--;
            return left;
        }
        root.right= removeMax(root.right);
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
