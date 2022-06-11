package 算法.other;

import java.util.Arrays;

/**
 * 给定一个数组nums，编写函数将所有的0移动到数组的末尾，并保持非零元素的相对顺序
 */
public class MoveZero {

    public static void moveZero(int[] arr){
        int n= arr.length;
        for (int i =0; i < n; i++) {
            if (arr[i]==0){
            swap(arr,i);
                n--;
            }
          }
        }

    private static void swap(int[] arr,int i) {
        for (int k=i;k< arr.length-1;k++){
            int temp=arr[k];
            arr[k] =arr[k+1];
            arr[k+1] =temp;
        }
    }

    public static void main(String[] args) {
        int[] a={0,1,3,4,0,5};
        int[] b={0,2,1,0,8,9,0,5};
        moveZero(a);
        moveZero(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}

