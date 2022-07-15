package newCoder_leetCode.practice;

public class JZ7重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //标记访问到前序遍历的哪个位置
    private int index = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return buildHelper(pre, vin, 0, pre.length - 1);
    }

    //在前序遍历中借助中序遍历还原二叉树
    public TreeNode buildHelper(int[] pre, int[] vin, int left, int right) {
        if (left > right) {
            //空区间
            return null;
        }
        if (index == pre.length) {
            //前序遍历已经处理完了
            return null;
        }
        TreeNode root = new TreeNode(pre[index]);
        index++;
        int pos = find(root.val, vin);
        root.left = buildHelper(pre, vin, left, pos - 1);
        root.right = buildHelper(pre, vin, pos + 1, right);
        return root;
    }

    //在中序
    public int find(int val, int[] vin) {
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == val) {
                return i;
            }
        }
        return -1;
    }
}

