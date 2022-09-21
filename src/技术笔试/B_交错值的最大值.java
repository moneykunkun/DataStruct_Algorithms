package 技术笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B_交错值的最大值 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        //map集合存储数组元素对应的数组下标
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i );
        }
        int[] del =new int[n/2];
        for (int i = n; i >=0; i--) {
            del[i/2] =arr[i];
        }
        Arrays.sort(del);
        int max =del[0];
        int index=map.get(max);
        swap(arr,index-1,index);
        int sum =0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println(sum);
    }
    public  static  void  swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
