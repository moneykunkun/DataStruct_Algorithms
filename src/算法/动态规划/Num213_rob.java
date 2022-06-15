package 算法.动态规划;

/**
 * 打家劫舍 II
 */
public class Num213_rob {
    public int rob(int[] nums) {
    int len = nums.length;
    if (len==1){
        return nums[0];
    }
    if (len==2){
        return Math.max(nums[0],nums[1]);
    }
    //第一个房间可以偷，最后一个房间不能偷
        int[] dp1 =new int[len+1];
    //第一个房间不可以偷，最后一个房间可以偷
        int[] dp2 =new int[len+1];
        //初始化
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);
        //第一个房间不能偷，从第二个房间开始
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1],nums[2]);
        for(int i=2;i<len-1;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }
        for (int i=3;i<len;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[len-2],dp2[len-1]);
    }
}
