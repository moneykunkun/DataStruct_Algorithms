package newCoder101.递归回溯;

public class BM57岛屿数量 {

    /**
     * 矩阵中多处聚集着1，要想统计1聚集的堆数而不重复统计，那我们可以考虑每次找到一堆相邻的1，就将其全部改成0，
     * 而将所有相邻的1改成0的步骤又可以使用深度优先搜索（dfs）：当我们遇到矩阵的某个元素为1时，首先将其置为了0，
     * 然后查看与它相邻的上下左右四个方向，如果这四个方向任意相邻元素为1，则进入该元素，进入该元素之后我们发现又回到了刚刚的子问题，
     * 又是把这一片相邻区域的1全部置为0，因此可以用递归实现
     * @param grid
     * @param i
     * @param j
     */
        //深度优先遍历与i，j相邻的所有1
        public void dfs(char[][] grid, int i, int j) {
            int n = grid.length;
            int m = grid[0].length;
            // 置为0
            grid[i][j] = '0';
            //后续四个方向遍历
            if(i - 1 >= 0 && grid[i - 1][j] == '1')
                dfs(grid, i - 1, j);
            if(i + 1 < n && grid[i + 1][j] == '1')
                dfs(grid, i + 1,j);
            if(j - 1 >= 0 && grid[i][j - 1] == '1')
                dfs(grid, i, j - 1);
            if(j + 1 < m && grid[i][j + 1] == '1')
                dfs(grid, i, j + 1);
        }

        public int solve (char[][] grid) {
            int n = grid.length;
            //空矩阵的情况
            if (n == 0)
                return 0;
            int m = grid[0].length;
            //记录岛屿数
            int count = 0;
            //遍历矩阵
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    //遍历到1的情况
                    if(grid[i][j] == '1'){
                        //计数
                        count++;
                        //将与这个1相邻的所有1置为0
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
    }

