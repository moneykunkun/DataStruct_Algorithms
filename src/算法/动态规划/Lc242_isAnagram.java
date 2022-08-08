package 算法.动态规划;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 */
public class Lc242_isAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] sChar =s.toCharArray();
        char[] tChar =t.toCharArray();

        int[] dict =new int[26];
        for (int i = 0; i <sChar.length ; i++) {
            dict[sChar[i]='a']++;
        }
        for (int j = 0; j < tChar.length; j++) {
            dict[tChar[j]='a']--;
            if (dict[tChar[j]-'a']<0){
                return false;
            }
        }
        return true;
    }


}
