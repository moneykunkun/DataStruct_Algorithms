package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48_最长不含重复字符的子字符串 {

    public int lengthOfLongestSubstring(String s) {
        //记录字串对应的索引
        Map<Character,Integer> map =new HashMap<>();
        int i=-1,res =0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res =Math.max(res,j-i);         //更新长度
        }
        return res;
    }
}
