import java.util.Scanner;

public class JD_2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        long[] arr =new long[n];
        long first =0,second =0;
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
            if (i%2==0) first =Math.max(first,arr[i]);
            else second =Math.max(second,arr[i]);
        }
        if (first ==second){
            System.out.println(Math.min(minNum(arr,first+1,second),minNum(arr,first,first+1)));
        }else {
            System.out.println(minNum(arr,first,second));
        }
    }

    private static long minNum(long[] arr, long first, long second) {
        long ans=0;
        for (int i = 0; i < arr.length; i++) {
            long num=i%2==0?first-arr[i]:second-arr[i];
            ans+=num;
        }
        return ans;
    }
}
