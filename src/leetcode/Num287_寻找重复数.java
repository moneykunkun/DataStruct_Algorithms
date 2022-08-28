package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num287_寻找重复数 {

    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int num =-1;
        for (Map.Entry<Integer,Integer> entry:map.entrySet() ){
            if (entry.getValue()>1){
                 num =entry.getKey();
            }
        }
        return num;
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
