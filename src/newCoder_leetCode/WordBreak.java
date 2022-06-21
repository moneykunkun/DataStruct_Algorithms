package newCoder_leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，
 * 使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如: 给定s=“alibaba”；dict=[“ali”, “ba”].
 *         返回true，因为”alibaba”可以被分割成”ali,ba”.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict){
        //创建一个数组，保存字符串是否可被分割的状态
        boolean[] canBreak =new boolean[s.length()+1];
        canBreak[0]=true;
        //遍历字符串   分成两个数组：【0，j】、【j+1，i】
         for (int i = 1; i <=s.length() ; i++) {
            //j <i && F(j)----[j+1,i]
             for (int j = 0; j <i ; j++) {
                 if (canBreak[j] && dict.contains(s.substring(j,i))){
                     canBreak[i]=true;
                 }
             }
        }
         return canBreak[s.length()];

    }
    public static void main(String[] args) {
        String s="leetcode";
        Set<String> dic =new HashSet<>();
        dic.add("leet");
        dic.add("code");
        WordBreak wordBreak =new WordBreak();
        boolean b = wordBreak.wordBreak(s, dic);
        System.out.println(b);
    }
}
