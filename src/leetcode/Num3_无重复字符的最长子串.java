package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Num3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set= new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 滑动窗口的解题思路
     */

    public int lengthOfLongestSubstring2(String s) {
        //记录最大值的变量
        int maxLen =0;
        //定义两个指针
        int left =0;
        int right =0;
        //保存字符的集合
        Set<Character> set =new HashSet<>();
        while (right<s.length()){
            //如果窗口中包含当前元素，我们再继续添加就会出现重复值
            //所以在添加前，先将窗口最左端的元素移除掉，直到窗口不包含当前元素为止
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));         //移除窗口左边元素
                left++;             //左指针右移
            }
            //添加当前元素到集合中
            set.add(s.charAt(right));
            //更新最大值
            maxLen =Math.max(maxLen,set.size());
            //右指针移动
            right++;
        }
        return maxLen;
    }
}
