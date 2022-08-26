package leetcode;

public class Num200_岛屿数量 {

    /**
     * 岛屿数量
     * 深度优先遍历
     * @param
     * @return
     */
        public int numIslands(char[][] grid) {
            //记录岛屿的数量
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1'){
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int i, int j){
            //grid[i][j] 不在方格内直接退出
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            //从四个方向深度遍历
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

