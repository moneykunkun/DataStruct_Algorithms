package 算法.动态规划;

public class Num202_isHappy {
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
    }

