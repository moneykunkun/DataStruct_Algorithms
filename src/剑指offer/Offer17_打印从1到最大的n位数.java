package 剑指offer;

public class Offer17_打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        //最大数为10^n -1
        int len =(int) Math.pow(10,n)-1;
        int[] res =new int[len];
        for (int i = 0; i < len; i++) {
            res[i] =i+1;
        }
        return res;
    }
}
