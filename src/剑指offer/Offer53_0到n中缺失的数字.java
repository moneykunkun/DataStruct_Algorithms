package 剑指offer;

import java.util.HashSet;

public class Offer53_0到n中缺失的数字 {

    public int missingNumber(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        int n=nums.length;
        //先将数组中所有的数都加入到集合中
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int miss =-1;
        //从 0-n 依次加入集合 如果加入成功，表示集合中之前不存在该元素，即确实的元素就是i
        for (int i = 0; i <=n ; i++) {
            if (set.add(i)){
                miss =i;
                break;
            }
        }
        return miss;
    }
}
