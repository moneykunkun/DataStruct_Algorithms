package 算法.贪心;

import java.util.Arrays;

public class Lc455_分发饼干 {
    //先对两个数组进行排序
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //存储最多的数量
        int result=0;
        int index =0;
        for (int i = 0; i <s.length && index<g.length ; i++) {
            if (s[i] >=g[index]){
                index++;
                result++;
            }
        }
        return result;
    }
}
