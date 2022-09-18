package 技术笔试;

import java.util.HashMap;

public class Tencent {

    public int minOperations (String str) {
        // write code here
        int len =str.length();
        HashMap<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c =str.charAt(i);
            //统计每个字符出现的次数
            map.put(c,map.getOrDefault(c,0)+1);
        }
    return 0;
    }
}
