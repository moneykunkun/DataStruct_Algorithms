package 数据结构.二叉堆;

import java.util.Arrays;


public class HeapTest {
    public static void main(String[] args) {
        MaxHeap heap =new MaxHeap();
        int[] arr={10,13,8,7,6,15,20};
        for (int i:arr){
            heap.add(i);
        }
        heap.add(16);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=heap.extractMax();
        }
        System.out.println(Arrays.toString(arr));
    }
}
