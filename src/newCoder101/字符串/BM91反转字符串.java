package newCoder101.字符串;

public class BM91反转字符串 {

    public String solve (String str) {
        // write code here
        if (str ==null){
            return "";
        }
        StringBuilder sb =new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
