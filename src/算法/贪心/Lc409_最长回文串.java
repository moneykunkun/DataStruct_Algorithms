package 算法.贪心;

import java.util.HashMap;

public class Lc409_最长回文串 {

    public int longestPalindrome(String s) {
        int n =s.length();
         char[] chars = s.toCharArray();
        HashMap<Character,Integer> map =new HashMap<>();
        int maxLen =0;
        //统计每个字符出现的次数
        for (char c : chars) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        boolean flag = false;
      for (int num : map.values()) {
          if (num %2 ==0) {
              maxLen += num;
          }else {
              maxLen +=(num-1);
              flag = true;
          }
      }
      if (flag){
          maxLen++;
      }
    return maxLen;
    }
}
