package 技术笔试;


import java.util.HashMap;
import java.util.Scanner;

public class 支配数 {
    //滑动窗口
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int k=sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int num=0;
        int left =0,right=arr.length-1;
        for (int i = 0; i < n; i++) {
            if (map.get(arr[k])<=map.get(arr[i])){
                num++;
                right--;
            }else {
                left++;
            }
        }
        System.out.println(num);
    }
}
