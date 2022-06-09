package 数据结构.二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树
 */
public class MyBinTree {
    /**
     * 二叉树的节点类
     */
    private static class TreeNode{
        char val;                  //存储的节点值
        TreeNode left;       //根节点左子树
        TreeNode right;     //根节点的右子树
        //构造方法
        public TreeNode(char val) {
            this.val = val;
        }
    }

    /**
     * 创建一颗二叉树
     * @return
     */
    public static TreeNode build(){
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
        nodeE.right = nodeH;
        return nodeA;
    }

    /**
     * 前序遍历二叉树：根--左--右的顺序
     * 传入一个二叉树的根节点，按照根左右的顺序依次遍历二叉树
     * @param root
     */
    public static void preOrder(TreeNode root){
        //边界条件判断二叉树是否为空
        if (root == null){
            return ;
        }
        System.out.print(root.val+" ");       //先打印根节点的值
        //按照先序遍历的方式递归访问左子树
        preOrder(root.left);
        //按照先序遍历的方式递归访问右子树
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);         //先递归访问左子树
        System.out.print(root.val+" ");
        inOrder(root.right);       //最后递归访问右子树
    }

    /**
     * 后序遍历二叉树
     * @param root
     */
    public static void  postOrder(TreeNode root){
        if (root == null){
            return;
        }
        //递归访问左子树
        postOrder(root.left);
        //递归访问右子树
        postOrder(root.right);
        //最后访问根节点
        System.out.print(root.val+" ");
    }

    /**
     * 二叉树的层序遍历
     * 传入一颗二叉树的根节点，返回其层序遍历的结果
     * @param root
     */
    public static void levelOrder(TreeNode root){
                //边界条件
                if (root == null){
                    return ;
                }
                //借助队列实现遍历过程
        Deque<TreeNode> deque =new LinkedList<>();
        deque.offer(root);
        while (! deque.isEmpty()){
            //循环遍历，取出队列中元素加入到list集合中
            int size =deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur =deque.poll();
                System.out.print(cur.val+" ");
                //处理左树
                if (cur.left != null){
                    deque.offer(cur.left);
                }
                //处理右树
                if (cur.right != null){
                    deque.offer(cur.right);
                }
            }
        }
    }
    /**
     * 传入一个二叉树的根节点获取当前二叉树的节点个数
     * @param root
     * @return  节点个数
     */
    public static int getNodes(TreeNode root){
        //判断二叉树是否为空
        if ( root == null){
            return 0;
        }
        //二叉数不为空，则根节点算一个+根节点的左子树+根节点的右子树
        return 1+getNodes(root.left)+getNodes(root.right);
    }

    /**
     * 层序遍历的方式获取二叉树的节点个数
     * @param root
     * @return
     */
    public static int getNodesNonRecursion(TreeNode root) {
        if (root == null){
            return 0;
        }
        int size = 0;           //统计节点个数
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);          //先将根节点入队
        while (!queue.isEmpty()){
            //队列不为空时，将队列元素出队，节点个数++
            TreeNode cur = queue.poll();
            size++;
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return size;
    }

    /**
     * 传入一个二叉树的根节点，获取当前二叉树的叶子节点个数
     * @param root
     * @return  叶子节点
     */
    public static int getLeafNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        //判断当前节点的左右子树是否为空
        if ( root.left ==null && root.right == null){
            return 1;
        }
        //当前树不为空，且存在左右子树，返回叶子接待你个数
        return  getLeafNodes(root.left)+getLeafNodes(root.right);
    }

    /**
     * @author qk
     * @date 2022/3/11 12:13
     * 使用层序遍历的方式获取叶子节点个数
     * 非递归的方式
     */
    public static int getLeafNodesNonRecursion(TreeNode root){
        if ( root == null){
            return 0;
        }
        int size = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //只有当cur是叶子节点时，计数器才++
            if (cur.left ==null && cur.right == null){
                size++;
                continue;
            }
            if (cur.left !=null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return size;
    }
    /**
     * 判断以root为根节点的二叉树是否包含指定元素val
     * @param root  根节点
     * @param val   指定节点
     * @return
     */
    public static boolean contains(TreeNode root,char val){
        if ( root == null){
            return false;
        }
        if ( root.val ==val){
            return true;
        }
        //二叉树不为空且根节点值不是val，则在子树中继续寻找
        return contains(root.left,val) || contains(root.right,val);
    }

    /**
     * 传入一个二叉树的根节点，返回二叉树的高度
     * @param root
     * @return  树高
     */
    public static int height(TreeNode root){
        if ( root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int max =Math.max(leftHeight,rightHeight);
        return max+1;
    }

    /**
     * 获取以root为根节点的二叉树第K层的节点个数
     * @param root
     * @param k 表示层数
     * @return  k曾节点个数
     */
    public static int getKLevelNodes(TreeNode root,int k){
        //边界条件
        if ( root == null && k<=0){
            return 0;
        }
        if (k ==1){
            return 1;
        }
        //此时二叉树不为空且 k>=2
        //将二叉树问题拆分为左右子树的子问题：以root为根节点的第K层 == 以root.left为根的 k-1层 +root.right为根的k-1层
        return getKLevelNodes(root.left,k-1) +getKLevelNodes(root.right,k-1);
    }
    public static void main(String[] args) {
        //测试先序遍历
        TreeNode root = build();        //创建一颗二叉树
        System.out.print("前序遍历的顺序是：");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历的顺序是：");
        inOrder(root);
        System.out.println();
        System.out.print("后序遍历的结果是：");
        postOrder(root);
        System.out.println();
        System.out.print("层序遍历的结果是：");
        levelOrder(root);
    }
}
