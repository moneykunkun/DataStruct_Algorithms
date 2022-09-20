package 算法.贪心;

public class Lc11_盛最多水的容器 {

    //双指针
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        //记录最大值
        int ans = 0;
        while (left < right) {
            //最大面积 = 左右边界的较小者 * 边界距离的差值
        int maxArea = Math.min(height[left],height[right]) * (right-left);
            //更新最大值
        ans = Math.max(ans,maxArea);
        if (height[left] <= height[right]){
           //左指针移动
            ++left;
        }else {
            //右指针移动
            ++right;
        }
        }
        return ans;
    }
    //贪心解法
    public int maxArea1(int[] height) {
        int maxArea =0;
        int left=0, right=height.length-1;
        while (left < right) {
            if (height[left] <= height[right]) {
                int area = (right - left) * (height[left]);
                maxArea =Math.max(area,maxArea);
                left++;
            }else {
                int area = (right - left) * (height[right]);
                maxArea = Math.max(area,maxArea);
                right--;
            }
        }
        return maxArea;
    }
}
