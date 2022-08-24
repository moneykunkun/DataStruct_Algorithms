package leetcode;

public class Num11_盛最多水的容器 {

    public int maxArea(int[] height) {
        int n =height.length;
        if(n<2){
            return 0;
        }
        int ans =0;
        int left =0;
        int right =n-1;
        while(left <right){
            int capacity =Math.min(height[left],height[right])*(right-left);
            ans =Math.max(capacity,ans);
            if(height[left] <height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
