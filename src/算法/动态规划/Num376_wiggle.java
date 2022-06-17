package 算法.动态规划;


//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列
public class Num376_wiggle {
    public int wiggleMaxLength(int[] nums) {
    int len =nums.length;
    int up =1;
    int down =1;
    for (int i=1;i<len;i++){
        if (nums[i]-nums[i-1]>0){
            up =down+1;
        }else if(nums[i]-nums[i-1]<0) {
            down =up+1;
        }
    }
    return Math.max(up,down);
    }
}
