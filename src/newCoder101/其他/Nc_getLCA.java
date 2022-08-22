package newCoder101.其他;

public class Nc_getLCA {
    /**
     * 将一棵无穷大满二叉树的结点按根结点一层一层地从左往右编号，根结点编号为1。
     * 现给定a，b为两个结点。设计一个算法，返回a、b最近的公共祖先的编号。
     * https://www.nowcoder.com/questionTerminal/70e00e490b454006976c1fdf47f155d9
     * @param a
     * @param b
     * @return
     *
     * 由于该二叉树编号是从1开始的，所以其父亲节（parent）和孩子节点（child）之间有一下转换关系parent=child/2
     */
    public int getLCA(int a,int b){
        while (a !=b){
            if (a>b){
                a/=2;
            }else {
                b/=2;
            }
        }
        return a;
    }

}
