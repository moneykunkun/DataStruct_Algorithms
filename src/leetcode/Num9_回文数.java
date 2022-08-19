package leetcode;

public class Num9_回文数 {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        //将数字反转
        int reverse =0;
        int num =x;
        while (num !=0){
            reverse =reverse*10+num%10;
            num/=10;
        }
        return x==reverse;
    }
}
