package newcoder;

public class Nc_顺时针打印矩阵 {
    /**
     * https://www.nowcoder.com/questionTerminal/97e7a475d2a84eacb60ee545597a8407
     *
     * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
     * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
     */
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        //左上角坐标
        int x1 =0;
        int y1 =0;
        //右下角坐标
        int x2 =n-1;
        int y2 =m-1;
        //结果集
        int[] ans =new int[n*m];
        int index =0;
        while (x1<=x2 && y1<=y2){
            //第一行 ：x1,y1~y2
            for (int i = y1; i <=y2 ; i++) {
                ans[index++] = mat[x1][i];
            }
            //最后一列 : x1+1~x2，y2
            for (int i=x1+1; i<=x2; i++){
                ans[index++] = mat[i][y2];
            }
            //最后一行 ： x2,y2-1~y1
            if (x1 < x2){
                for (int i=y2-1;i>=y1;i--){
                    ans[index++] = mat[x2][i];
                }
            }
            //第一列 ： x2-1~x1+1,y1 y1<y2
            if (y1 <y2){
                for (int i=x2-1;i>x1;i--){
                    ans[index++] =mat[i][y1];
                }
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return ans;
    }
}
