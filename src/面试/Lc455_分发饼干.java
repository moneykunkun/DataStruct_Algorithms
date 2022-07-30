package 面试;

import java.util.Arrays;

public class Lc455_分发饼干 {

    /**
     * 贪心+排序
     *思路：大尺寸的饼干既可以满足胃口大的孩子也可以满足胃口小的孩子，那么就应该优先满足胃口大的。
     * 排序两个数组，从右到左遍历，用大饼干首先满足胃口大的小孩
     * 复杂度：时间复杂度O(mlogm + nlogn)。空间复杂度O(logm + logn)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //遍历饼干数组索引
        int index=0;
        //存储可以分发的数量
        int result=0;
        for (int i = 0; i < s.length&& index<g.length; i++) {
            //该饼干能满足孩子的胃口
            if (s[i]>=g[index]){
                index++;
                result++;
            }
        }
        return result;
    }
}
