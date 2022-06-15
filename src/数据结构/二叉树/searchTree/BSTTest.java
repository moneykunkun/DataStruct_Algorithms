package 数据结构.二叉树.searchTree;

public class BSTTest {
    public static void main(String[] args) {
        int[] data = {28,16,30,13,22,29,48};
        BST bst = new BST();
        for ( int i:data ) {
            bst.add(i);
        }
        System.out.println(bst);
        System.out.println(bst.findMin());
        System.out.println(bst.findMax());
        System.out.println(bst.removeMin());
        System.out.println(bst.removeMax());
        bst.remove(30);
        System.out.println(bst);
    }
}
