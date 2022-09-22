package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59_滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        //形成k区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        int[] ans = new int[n - k + 1];
        int cnt = 0;
        ans[cnt++] = deque.getFirst();
        //k区间形成
        for (int i = k; i < n; i++) {
            //如果将要删除的nums[i-k]是之前k区间的最大值，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            //删除队列中比当前值小的值，因为我们只需要获得当前k区间的最大值[i-k+1,k]
            //这样能保存队列非递减有序
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[cnt++] = deque.getFirst();
        }
        return ans;
    }

}
