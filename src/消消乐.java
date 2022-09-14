import java.util.ArrayDeque;
import java.util.Scanner;

public class 消消乐 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        String[] strings =new String[n];
        for (int i = 0; i < n; i++) {
           strings[i] =sc.nextLine();
        }
        for (String string : strings) {
            String s=deleteChar(string);
            if (s.length() ==string.length()){
                System.out.println("No");
            }else if (s.length()>0){
                System.out.println("Yes");
            }else if (s.length()==0){
                System.out.println("No");
            }
        }

    }
        //消除相邻字符
        public static  String deleteChar(String s){
            ArrayDeque<Character> deque =new ArrayDeque<>();
            char c;
            for (int i = 0; i < s.length(); i++) {
                c =s.charAt(i);
                if (deque.isEmpty() || deque.peek() !=c){
                    deque.push(c);
                }else {
                    deque.pop();
                }
            }
            String s1 ="";
            while (!deque.isEmpty()){
                s1+=deque.pop();
            }
            return s1;
        }
      /*  public static  String deleteChar(StringBuilder stringBuilder){
        StringBuilder sb =new StringBuilder();
            if (stringBuilder !=null && stringBuilder.length() !=0){
                stringBuilder.append(" ");
                //是否有相同的匹配字符
                boolean flag =false;
                char c =stringBuilder.charAt(0);
                for (int i = 1; i <stringBuilder.length() ; i++) {
                    if (c==stringBuilder.charAt(i)){
                        flag =true;
                    } else {
                      if (!flag){
                          sb.append(c);
                      }
                      c=stringBuilder.charAt(i);
                      flag =false;
                    }
                }
                if (sb.length()+1 <stringBuilder.length()){
                    return deleteChar(sb);
                }
            }
            return sb.toString();
        }*/
}
