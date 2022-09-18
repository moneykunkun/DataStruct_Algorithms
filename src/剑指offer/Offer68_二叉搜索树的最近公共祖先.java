package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class Offer68_二叉搜索树的最近公共祖先 {

    /**
     * 解题思路：二叉搜索树：可以根据节点值比较将查找当前节点得路径加入到集合中
     * 最后遍历集合 ，找到集合中相交索引得最大值就是公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathA=getPath(root,p);
        List<TreeNode> pathB= getPath(root,q);
        TreeNode ancestor =null;
        for (int i=0;i<pathA.size() && i<pathB.size();i++){
            if (pathA.get(i)==pathB.get(i)){
                ancestor =pathA.get(i);
            }else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 查找节点得路径
     * @param root
     * @param
     * @return
     */
    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path =new ArrayList<>();
        TreeNode node =root;
        while (node !=target){
            //先将根节点加入到路径中
            path.add(node);
            if (node.val>target.val){
                //当前节点值大于目标节点值，在左树中继续
                node =node.left;
            }else {
                node=node.right;
            }
        }
        path.add(node);
        return path;
    }
}
