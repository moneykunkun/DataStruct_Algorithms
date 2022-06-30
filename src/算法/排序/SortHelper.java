package 算法.排序;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 排序的辅助类
 * 生成测试数组，以及对排序算法进行测试
 */
public class SortHelper {
    //生成随机数的对象
    private static final ThreadLocalRandom random =ThreadLocalRandom.current();

    /**
     * 在区间【left...right】上生成随机数数组
     * @param n
     * @param left
     * @param right
     * @return
     */
    public static int[] generateRandomArray(int n,int left,int right){
      int[] arr =new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =random.nextInt(left,right);
        }
        return arr;
    }

    /**
     * 生成一个大小为n的近乎有序的数组
     * @param n        数组的大小
     * @param times 交换的次数，次数越大越无序
     * @return
     */
    public static int[] generateSortedArray(int n,int times){
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i;
        }
        //交换数组部分元素，交换次数越小，越有序
        for (int i = 0; i < times; i++) {
            //生成一个【0，n】上的随机数
            int a =random.nextInt(n);
            int b =random.nextInt(n);
            int temp =arr[a];
            arr[a] =arr[b];
            arr[b]=temp;
        }
        return arr;
    }

    //生成一个拷贝数组
    public static int[] arrCopy(int[] arr){
        return Arrays.copyOf(arr,arr.length);
    }

    /**
     * 测试性能的方法，反射的知识
     * 根据传入的方法名称就能对arr数组进行排序
     * @param sortName
     * @param arr
     */
    public static void testSort(String sortName,int[] arr){
        Class<HeapSort> cls =HeapSort.class;      //获取反射对象
        try {
            Method method =cls.getDeclaredMethod(sortName,int[].class);
            long start =System.nanoTime();          //获取系统的时间，纳秒为单位
            method.invoke(null,arr);            //调用方法
            long end =System.nanoTime();
            if (isSorted(arr)){
                //排序正确
                System.out.println(sortName+"排序结束，共耗时："+(end-start)/1000000.0+"ms");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    /**
     * 判断数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("sort error");
                return false;
            }
        }
        return true;
    }

}
