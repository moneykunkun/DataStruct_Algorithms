package 数据结构.二叉树.searchTree;

import java.util.NoSuchElementException;

/**以整形为例的二分搜索树
 * 二分搜索树概念：以中序遍历结果是一个升序序列（完全二叉树），树中不存在重复的元素
 * @author qk
 * @date 2022/3/11 21:21
 */
public class BST {
    private class TreeNode{
        private int val;                     //节点值
        private TreeNode left;       //左子树
        private TreeNode right;     //右子树

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int size ;
    private TreeNode root;          //根节点

    /**
     * 向二分搜索树中添加元素
     * @param val
     */
    public void add(int val){
        root=add(root,val);
    }

    /**
     * 向以root为根节点的树中添加元素
     * @param root
     * @param val
     * @return
     */
    private TreeNode add(TreeNode root, int val) {
        if (root == null){
            TreeNode newNode = new TreeNode(val);
            //此时添加的元素就是根节点
            size++;
            return newNode;
        }
        if (val < root.val){
            //向左树中添加val
            root.left = add(root.left,val);
        }
        if (val > root.val){
            //向右树中添加val
            root.right = add(root.right,val);
        }
        return root;
    }

   /**
     * 找到二分搜索树的最小值
     * @return
     */
    public int findMin(){
        if (size == 0){
            //空树
            throw new NoSuchElementException("BST is empty");
        }
        TreeNode minNode = minNode(root);
        return minNode.val;
    }

    /**
     * 查找以root 为根节点的子树中的最小值节点
     * @param root
     * @return
     */
    private TreeNode minNode(TreeNode root) {
        if (root.left == null){
            return root;
        }
        //一直递归访问左子树
        return minNode(root.left);
    }

    /**
     * 查找BST中的最大值
     * @return
     */
    public int findMax(){
        if (size == 0){
            return 0;
        }
        TreeNode maxNode = maxNode(root);
        return maxNode.val;
    }

    /**
     * 查找BST中最大值节点
     * @param root
     * @return
     */
    private TreeNode maxNode(TreeNode root) {
        if (root.right == null){
            return root;
        }
        //一直递归访问右子树
        return maxNode(root.right);
    }

    /**
     * 删除BST中的最小值节点，返回最小值
     * @return
     */
    public int removeMin(){
    int min = findMin();
    root = removeMin(root);
    return min;
    }

    /**
     * 找到以root为根节点的最小值节点，返回最小值节点
     * @param root
     * @return
     */
    private TreeNode removeMin(TreeNode root) {
        if (root.left == null){
            //此时，root就是最小值,先暂存一下右子树
            TreeNode right = root.right;
            root.right =root = null;
            size--;
            return right;
        }
        //递归去左子树中删除
        root.left = removeMin(root.left);
        return root;

    }

    /**
     * 删除BST中的最大值，并返回删除的节点值
     * @return
     */
    public  int removeMax(){
        int max= findMax();
        root = removeMax(root);
        return max;
    }

    /**
     * 删除BST中的最大值节点
     * @param root
     * @return
     */
    private TreeNode removeMax(TreeNode root) {
        if (root.right == null){
            //此时最大值节点就是root，暂存一下root.left
            TreeNode left = root.left;
            root.left = root =null;
            size--;
            return left;
        }
        //递归访问右子树
        root.right = removeMax(root.right);
        return root;
    }

    //删除BST中的任意元素
    public void remove(int val){
        root = remove(root,val);
    }

    /**
     * 在当前以root为根节点的BST中，删除值为val 的节点
     * @param root
     * @param val
     * @return
     */
    private TreeNode remove(TreeNode root, int val) {
        //边界，所有节点中都不存在值为val的节点
        if (root == null){
            throw new NoSuchElementException("BST 中不存在值为"+val+"的数");
        }else if (val <root.val){
            //在左树中查找待删除的节点
            root.left = remove(root.left,val);
            return root;
        }else if (val >root.val){
            //在右树中查找待删除的节点
            root.right = remove(root.right,val);
            return root;
        }else {
            //此时，root就是待删除的节点
            //拼接root的左右子树
            if (root.left ==null){
                TreeNode right = root.right;
                root.right = root =null;
                size--;
                return right;
            }
            //右树为空时
            if (root.right == null){
                TreeNode left = root.left;
                root.left =root=null;
                size--;
                return left;
            }
            //此时，root的左右树都不为空时，使用hibbard deletion分析
            TreeNode successor = removeMin(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right =root =null;
            return successor;
        }
    }

  /*  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }
*/
    /**
     * 先序遍历以root为根节点的BST，将节点值存到sb中
     * @param root
     * @param height
     * @param sb
     *//*
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
*/
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
