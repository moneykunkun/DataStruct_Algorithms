package 技术笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 零件组装 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //每个零件的个数
        int[] len =new int[4];
        for (int i = 0; i <4 ; i++) {
            len[i]=sc.nextInt();
        }
        //零件评分
        int x = sc.nextInt();
        //存储零年的数组
        int[] a1 = new int[len[0]];
        int[] a2 = new int[len[1]];
        int[] a3 = new int[len[2]];
        int[] a4 = new int[len[3]];

        for (int i = 0; i < len[0]; i++) {
           a1[i]  = sc.nextInt();
        }
        for (int i = 0; i < len[1]; i++) {
            a2[i]  = sc.nextInt();
        }
        for (int i = 0; i < len[2]; i++) {
            a3[i]  = sc.nextInt();
        }
        for (int i = 0; i < len[3]; i++) {
            a4[i]  = sc.nextInt();
        }
        //组成零件的个数取决于零件数最少的
        Arrays.sort(len);
        int minLen = len[0];
        int num = 0;      //组装零件的个数
        for (int i = 0; i <minLen ; i++) {
            if (a1[i]>x &&a3[i]>x &&a3[i]>x &&a4[i]>x){
                num++;
            }
        }
        System.out.println(num);
    }
}
