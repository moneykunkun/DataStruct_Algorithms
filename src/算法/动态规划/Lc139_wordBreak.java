package 算法.动态规划;

import java.util.List;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
public class Lc139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len =s.length();
        boolean[] dp =new boolean[len+1];
        dp[0] =true;
        for (int r = 1; r < len+1; r++) {
            for (int l=0;l<r;l++){
                //分为两端
                //[0...l] [l...r]
                if (dp[l]==true && wordDict.contains(s.substring(l,r))){
                    dp[r] =true;
                }
            }
        }
        return  dp[len];
    }
}
