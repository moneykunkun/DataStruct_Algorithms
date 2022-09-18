package 剑指offer;

public class Offer45_把数组排成最小的数 {
    /**
     * 快速排序对字符串数组进行排序
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs  =new String[nums.length];
        //将数字字符数组转为字符数组
        for (int i = 0; i < nums.length; i++) {
            strs[i] =String.valueOf(nums[i]);
        }
        //快速排序
        quickSort(strs,0,strs.length-1);
        StringBuilder sb= new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 对字符数组快速排序
     * @param strs
     * @param left
     * @param right
     */
    private void quickSort(String[] strs, int left, int right) {
        if (left>=right) return;
        int i=left,j=right;
        String temp=strs[i];
        while (i<j){
            while ((strs[j]+strs[left]).compareTo(strs[left]+strs[j])>=0 && i<j) j--;
            while ((strs[i]+strs[left]).compareTo(strs[left]+strs[i])<=0 && i<j) i++;
            temp=strs[i];
            strs[i] =strs[j];
            strs[j] =temp;
        }
        strs[i] =strs[left];
        strs[left] =temp;
        quickSort(strs,left,i-1);
        quickSort(strs,i+1,right);
    }

}
