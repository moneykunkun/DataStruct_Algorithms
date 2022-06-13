package 算法.other;

//https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
//无符号加法
public class Add {
     static int addAB(int A, int B) {
        if (A == 0) return B;
        if (B == 0) return A;
        int a = A ^ B;                   //相加的结果，没有进位
        int b = (A & B) << 1;       //只有进位
        return addAB(a, b);
    }

    public static void main(String[] args) {
        System.out.println(addAB(3,4));
    }
}
