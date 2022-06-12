package 算法.回溯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 幸运带 袋子里有N个球 如果所有球上的号码相加 大于所有球的积 则称这个袋子是幸运的
 * 每次从袋子中取出一个球 问有多少中方法使得这个袋子是幸运的
 */
public class Nc_lucky {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num = in.nextInt();
        int[] ball =new int[num];
        for (int i = 0; i < num; i++) {
            ball[i]= in.nextInt();
        }
        //对数组进行排序
        Arrays.sort(ball);
        luckyCount(ball,num,0,0,1);
    }

    private static int luckyCount(int[] ball, int num, int pos, int sum, int multiply) {
        int count=0;
        for (int i = pos; i <num ; i++) {
            sum+=ball[i];
            multiply*=ball[i];
            if (sum>multiply){
                //幸运的袋子
                count=count+1+luckyCount(ball,num,i+1,sum,multiply);
            }else if (ball[i]==1){
                //当前值是1可以进行循环
                count=count+luckyCount(ball,num,i+1,sum,multiply);
            }else {
                break;
            }
            //回溯
            sum=sum-ball[i];
            multiply=multiply/ball[i];
            while ( i< num-1 && ball[i]==ball[i+1]){
                i++;
            }
        }
        return count;
    }
}
