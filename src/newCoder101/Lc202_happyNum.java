package newCoder101;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Lc202_happyNum {

    //快慢指针的解法
    public boolean isHappy(int n) {
    int slow =next(n);
    int fast = next(next(n));
    while ( slow != fast){
        slow =next(slow);
        fast =next(next(fast));
    }
    if (fast ==1){
        return true;
    }
        return false;
    }
    //计算各个位的平方和
    public int next(int n){
        int ans=0;
        while (n != 0){
            int num =n%10;  //得到个位
            ans +=num*num;
            n /=10;
        }
        return ans;
    }
    //常规解法---超时
    public boolean isHappy2(int n) {
        Set<Integer> set =new HashSet<>();
        while (true){
            if (n==1){
                return true;
            }
            if (set.contains(n)){
                return false;
            }
            int temp =0;
            String str =Integer.toString(n);
            char[] chars =str.toCharArray();
            for (char c:chars){
                temp+=(c-'0')*(c-'0');
            }
            n=temp;
        }
    }
}
