package 算法.动态规划;

//年终奖
//https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
public class Nc_Bonus {
    public int getMost(int[][] board) {
        // write code here
        int row =board.length;
        int col =board[0].length;
        //初始化第一行
        for (int i = 1; i < col; i++) {
            //每一行的元素等于上一格的元素加上当前格元素
            board[0][i] +=board[0][i-1];
        }
        //初始化第一列
        for (int i = 1; i < row; i++) {
            //上一行加上当前行
            board[i][0] +=board[i-1][0];
        }
        //剩余位置
        for (int i = 1; i < row; i++) {
            for (int j=1;j<col;j++){
                board[i][j]=Math.max(board[i][j-1],board[i-1][j])+board[i][j];
            }
        }
    return board[row-1][col-1];
    }
}
