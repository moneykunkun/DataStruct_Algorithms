package 技术笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class XM_手机运行时长 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        while (sc.hasNext()) {
            int[] arr =new int[2];
             arr[0] = sc.nextInt();
             arr[1] = sc.nextInt();
             list.add(arr);
        }
    }

}
