package 算法.other;

/**
 *  求 1！+2！+3！+......+N！
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(fab(4));
    }

    public static int fab(int n) {
        int sum = 0;
        int cur=1;
        for (int i = 1; i <=n ; i++) {
            cur=cur*i;
            sum+=cur;
        }
        return sum;
    }
}
