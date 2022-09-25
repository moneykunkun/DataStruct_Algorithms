package 剑指offer;

import java.util.HashSet;

public class Offer53_0到n中缺失的数字 {

    public int missingNumber(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int miss =-1;
        for (int i = 0; i <=n ; i++) {
            if (set.add(i)){
                miss =i;
                break;
            }
        }
        return miss;
    }
}
