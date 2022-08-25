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

    public boolean canJump2(int[] nums) {
       int n =nums.length;
       int reach =0;
       //优化 如果直接能到达最后位置，就直接退出循环
       for (int i=0;i<=reach && reach <n-1;i++){
           reach =Math.max(reach,i+nums[i]);
       }
       //reach=n-1表示能达到最后位置
       return reach>=n-1;
    }


}
