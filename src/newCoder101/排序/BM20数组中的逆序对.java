package newCoder101.排序;

public class BM20数组中的逆序对 {

    /**
     * 数组中逆序对的个数
     * @param array
     * @return
     */

    public int InversePairs(int [] array) {
        int n=array.length;
        //存储逆序对的个数
        int[] ans =new int[n];
        return mergeSort(array,ans,0,n-1);
    }

    /**
     * 在合并的过程中求逆序对的个数
     * @param array
     * @param ans
     * @param left
     * @param right
     * @return  逆序对的个数
     */
    public int mergeSort(int[] array, int[] ans, int left,int right){
        //左区间的值大于右区间
        if (left >=right){
            return 0;
        }
        int mid=left+(right-left)>>1;
        //数组中总的逆序对的个数
        int count=mergeSort(array,ans,left,mid)+mergeSort(array,ans,mid+1,right);

    }

}
