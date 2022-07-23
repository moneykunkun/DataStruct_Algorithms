package newCoder101.字符串;

public class BM83字符串变形 {

    public String trans(String s, int n) {
        // write code here
        if (n==0){
            return s;
        }
        StringBuilder sb =new StringBuilder(s);
        for (int i = 0; i <sb.length() ; i++) {
            char c=sb.charAt(i);
            //大小写转换
            if (c>='A'&&c<='Z'){
                sb.append(c-'A'+'a');
            }else if (c>='a' && c<='z'){
                sb.append(c-'a'+'A');
            }else {
                //遇到空格，直接拼接
                sb.append(c);
            }

        }
        //将字符串反转
        sb=sb.reverse();
    }
}
