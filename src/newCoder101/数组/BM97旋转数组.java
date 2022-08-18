package newCoder101.数组;

public class BM97旋转数组 {

        public int[] solve (int n, int m, int[] a) {
            //取余，因为每次长度为n的旋转数组相当于没有变化
            m = m % n;
            //第一次逆转全部数组元素
            reverse(a, 0, n - 1);
            //第二次只逆转开头m个
            reverse(a, 0, m - 1);
            //第三次只逆转结尾m个
            reverse(a, m, n - 1);
            return a;
        }
        //反转函数
        public void reverse(int[] nums, int start, int end){
            while(start < end){
                swap(nums, start++, end--);
            }
        }
        //交换函数
        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

