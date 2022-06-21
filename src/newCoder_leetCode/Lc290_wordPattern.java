package newCoder_leetCode;

import java.util.HashMap;
import java.util.Map;

//单词规律
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
public class Lc290_wordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map =new HashMap<>();
        //将字符串按空格拆分
        String[] split = s.split(" ");
        //长度不等
        if (pattern.length() != split.length) return false;
        //遍历pattern字符串
        for (int i = 0; i < pattern.length(); i++) {
            if ( !map.containsKey(pattern.charAt(i))){
                //集合中不存在key,却存在对应的value
                if (map.containsValue(split[i])){
                    return false;
                }
                map.put(pattern.charAt(i),split[i]);
            }else {
                //集合中存在key
                if (!map.get(pattern.charAt(i)).equals(split[i])) return false;
            }
        }
        return true;
    }

}
