package 技术笔试;

public class GLD_跳跃游戏1 {
    /**
     * 贪心算法
     * i+nums[i] 表示可以跳跃的最远距离
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int reach =0;           //表示最远可以到达的位置索引
        for (int i = 0; i < n; i++) {
            if (i>reach){
                //当前位置已经超过了可以到达的最远距离
                return false;
            }
            //更新最远可以到达的位置
            reach =Math.max(reach,nums[i]+i);
        }
        return true;
    }
}
