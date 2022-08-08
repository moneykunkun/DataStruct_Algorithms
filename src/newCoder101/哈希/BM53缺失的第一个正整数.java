package newCoder101.哈希;

import java.util.HashMap;
import java.util.Map;

public class BM53缺失的第一个正整数 {

    public int minNumberDisappeared (int[] nums) {
        // write code here
        int n=nums.length;
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],1);
        }
        //记录未出现的数字
        int res=1;
        while (map.containsKey(res)){
            res++;
        }
        return res;
    }
}
