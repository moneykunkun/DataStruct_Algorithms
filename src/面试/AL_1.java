package 面试;

public class AL_1 {
    /**
     * 无重复字符串的最大长度
     */
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb =new StringBuilder();
        //记录最长无重复字符串的长度
        int ans =0;
        for (int i = 0; i < s.length(); i++) {
            String c =String.valueOf(s.charAt(i));
            if (sb.indexOf(c) >=0){
                //当前字符在前面出现过，则删除当前字符在左侧出现位置及其之前所有的字符
                sb.delete(0,sb.indexOf(c)+1);
            }
            //否则直接拼接字符串
            sb.append(c);
            //更新最大值
            ans =Math.max(ans,sb.length());
        }
        return ans;
    }
}
