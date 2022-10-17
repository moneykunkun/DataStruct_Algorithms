package 剑指offer;

public class Offer002_二进制加法 {
    public String addBinary(String a, String b) {
        int sum= Integer.parseInt(a,2)+Integer.parseInt(b,2);
        return Integer.toBinaryString(sum);
    }
}
