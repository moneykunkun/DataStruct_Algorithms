package 剑指offer;

import java.util.HashMap;

public class Offer50_第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
    HashMap<Character,Integer> map =new HashMap<Character,Integer>();
          char[] chars =s.toCharArray();
             for(char c:chars){
                map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<s.length();i++) {
            char c =s.charAt(i);
            while (map.get(c)==1){
                return c;
            }
        }
        return ' ';
    }
}
