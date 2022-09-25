package 剑指offer;

public class Offer58_翻转单词顺序 {

    public String reverseWords(String s) {
        //去除首尾的空格后按空格拆分
        String[] str = s.trim().split(" ");
        StringBuilder sb =new StringBuilder();
        //倒序遍历数组
        for (int i = str.length-1; i >=0 ; i--) {
            if (str[i].equals("")){         //遇到空单词就跳过
                continue;
            }else {
                sb.append(str[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
