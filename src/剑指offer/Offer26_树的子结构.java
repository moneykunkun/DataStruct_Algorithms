package 剑指offer;

public class Offer26_树的子结构 {

    /**
     * 判断B是否是A的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null && B==null) return true;
        if (A==null || B==null) return false;
        return isSame(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    /**
     * 判断两棵树是否相同
     * @param a
     * @param b
     * @return
     */
    private boolean isSame(TreeNode a, TreeNode b) {
             if (b==null) return true;
            if (a==null) return false;
            return a.val == b.val && isSame(a.left,b.left) && isSame(a.right,b.right);
    }
}
