package 数据结构.二叉堆;

public class HeapTest {
    public static void main(String[] args) {
        MaxHeap heap =new MaxHeap();
        int[] arr={10,13,8,7,6,15,20};
        for (int i:arr){
            heap.add(i);
        }
        heap.add(16);
        System.out.println(heap);
    }
}
