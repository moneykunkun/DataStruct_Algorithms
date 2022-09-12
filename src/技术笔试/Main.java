package 技术笔试;

import java.util.ArrayList;


public class Main {
    //数组和为0
    public static void main(String[] args) {
        int[] arr ={-3,1,2,-3,4};
        System.out.println(subNumZero(arr));
    }

    static ArrayList<ArrayList<Integer>> result =new ArrayList<>();
    public static int   subNumZero(int[] arr){
        ArrayList<Integer> list =new ArrayList<>();
        if (arr ==null || arr.length ==0){
            result.add(list);
        }
        for (int i = 0; i < arr.length ; i++) {
            int sum =arr[i];
            if (sum ==0){
                list.add(i);
                list.add(i);
                result.add(list);
            }else {
                list.add(i);
            }
            for (int j = i+1; j < arr.length ; j++) {
                sum+=arr[i];
                if (sum ==0){
                    list.add(j);
                   result.add(list);
                }
            }
            list.clear();
        }
        return result.size();
    }
}
