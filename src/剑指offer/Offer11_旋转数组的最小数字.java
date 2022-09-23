package 剑指offer;

public class Offer11_旋转数组的最小数字 {

    //二分查找
    public int minArray(int[] numbers) {
        int left =0;
        int right =numbers.length-1;
        while (left<right){
            int mid =left+(right-left)/2;
            if (numbers[mid] >numbers[right]){
                //左区间已经有序
                left=mid+1;
            }else if (numbers[mid] <numbers[right]){
                //右区间已经有序
                right =mid;
            }else if (numbers[mid] ==numbers[right]){
                right--;
            }
        }
        return numbers[left];
    }
}
