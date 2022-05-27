package 算法.分治;


public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }

    /**
     *
     * @param n     盘子的数量
     * @param a             柱子A
     * @param b             柱子B
     * @param c             柱子C
     */
    public static void hanoiTower(int n,char a,char b,char c){
        if (n==1){
            //把A->C
            System.out.println("第"+n+"个盘从 "+a+"->"+c);
        }else {
            //把所有的盘子看作只有最后一个和 上面的全部 这两部分
            //1.把上面的所有盘子从 A->B,需要借助c盘
            hanoiTower(n-1,a,c,b);
            //2.把最后一个盘从 A->C
            System.out.println("第"+n+"个盘从 "+a+"->"+c);
            //3.把b柱上的所有盘从 B->C,需要借助a盘
            hanoiTower(n-1,b,a,c);
        }
    }
}
