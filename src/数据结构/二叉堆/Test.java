package 数据结构.二叉堆;

import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {
    int[] data =new int[100000];
        //生成0-整形最大值的随机数
        ThreadLocalRandom random =ThreadLocalRandom.current();
        for (int i = 0; i < data.length ; i++) {
            data[i] =random.nextInt(0,Integer.MAX_VALUE);
        }
        MaxHeap heap =new MaxHeap();
        for (int i:data){
            heap.add(i);
        }
        //堆排，不断取出堆中的最大值
        for (int i = 0; i < data.length; i++) {
            data[i]= heap.extractMax();
        }
        System.out.println(isSorted(data));
    }

    private static boolean isSorted(int[] data) {
        for (int i = 0; i < data.length-1; i++) {
            if (data[i]<data[i+1]){
                return false;
            }
        }
        return true;
    }
}
