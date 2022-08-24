package newCoder101.其他;

import java.util.Scanner;

public class Nc_numStr {

    /**
     *读入一个字符串，输入字符串中连续最长的数字串
     */
        public static void main(String[] args) {
            Scanner in =new Scanner(System.in);
            String str =in.nextLine();
            String res=maxLongNum(str);
            System.out.println(res);
        }
        //返回字符换中最长的数字串
        private static String maxLongNum(String str) {
            int start =0;       //数字串的开始索引
            int end =0;        //数字串的结束索引
            int max =0;         //最长数字串的长度
            int length =str.length();
            int index =0;           //最大数字串开始的索引
            //遍历字符串
            while (end<length){
                while (end<length && !Character.isDigit(str.charAt(end)) ){
                    end++;
                }
                start =end;
                while (end<length && !Character.isLetter(str.charAt(end))){
                    end++;
                }
                if (end-start>max){
                    max =end-start;
                    index =start;
                }
            }
            return str.substring(index,index+max);
        }
    }

