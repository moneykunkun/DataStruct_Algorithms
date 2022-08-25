package leetcode;

public class Num55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int reach =0;           //表示可到达的索引
        int n =nums.length;
        for (int i = 0; i <n ; i++) {
            if (i>reach){
               //超出所能到达的位置
               return  false;
            }
            reach =Math.max(reach,i+nums[i]);
        }
        return true;
    }
}
