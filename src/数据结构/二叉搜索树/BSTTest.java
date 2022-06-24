package 数据结构.二叉搜索树;

public class BSTTest {
    public static void main(String[] args) {
        int[] data ={1,10,15,12,8,50,13,25,14,20};
        BinarySearchTree bt =new BinarySearchTree();
        for (int i:data){
            bt.add(i);
        }
        System.out.println(bt);
        System.out.println("------------");

        bt.remove(50);
        System.out.println("-----------------------");
        System.out.println(bt);
        //System.out.println(bt.findMax());
    }
}
