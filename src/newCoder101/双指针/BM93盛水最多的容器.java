package newCoder101.双指针;

public class BM93盛水最多的容器 {

    public int maxArea (int[] height) {
        int n = height.length;
        //边界值
        if (n < 2) {
            return 0;
        }
        //存储最大值
        int ans = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            //计算区域谁容量
            int capacity = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(capacity, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
