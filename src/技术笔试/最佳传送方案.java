package 技术笔试;

import java.util.Scanner;

public class 最佳传送方案 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] peek =new int[n];
        for (int i = 0; i <n ; i++) {
            peek[i] =sc.nextInt();
        }
        System.out.println(minSpend(peek,k));
    }

    //最小花费贪心算法
    private static int minSpend(int[] peek, int k) {
        //标记当前位置是否已经被遍历
        boolean[] flag = new boolean[peek.length];
        int min=0;
        for (int i =0;i<=peek.length-1;i++) {
            int minSpend =peek[i+1]-peek[i];
          if (peek[i]<peek[i+1]){

          }
        }
    return min;
    }
}
