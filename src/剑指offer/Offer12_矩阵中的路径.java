package 剑指offer;

public class Offer12_矩阵中的路径 {

    //链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof

    /**
     * dfs+剪枝
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
         char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,chars,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     * @param board
     * @param chars
     * @param i
     * @param j
     * @param k
     * @return
     */
    private boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        //边界条件
        if(i<0 ||i>=board.length || j<0 ||j>=board[0].length || board[i][j] !=chars[k]){
            return false;
        }
        if (k==chars.length-1){
            //遍历到字符串末尾仍旧满足条件
            return true;
        }
        //剑指操作，将board[i][j] 置为‘\0’
        board[i][j] ='\0';
        boolean flag = dfs(board,chars,i+1,j,k+1) ||dfs(board,chars,i-1,j,k+1)
                                ||dfs(board,chars,i,j+1,k+1) ||dfs(board,chars,i,j-1,k+1);
        board[i][j] =chars[k];
        return flag;
    }
}
