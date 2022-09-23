package 剑指offer;

public class Offer15_二进制中1的个数 {

    //无符号右移
    public int hammingWeight(int n) {
        int res =0;
        while (n!=0){
            //n&1 =1 ,表示n最右以为为1，n&1 =0,表示n最右侧一位为0
            res +=n&1;
            //无符号右移一位
            n>>>=1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
