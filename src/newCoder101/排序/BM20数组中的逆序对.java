package newCoder101.排序;

public class BM20数组中的逆序对 {

    /**
     * 数组中逆序对的个数
     * @param array
     * @return
     */
    public int mod = 1000000007;
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
        //防止溢出
        count %= mod;
        //划分后的数组起始位置索引
        int i=left;
        int j=mid+1;
        for(int k = left; k <= right; k++)
            array[k] = ans[k];
        for(int k = left; k <= right; k++){
            if(i == mid + 1)
                array[k] = ans[j++];
            else if(j == right + 1 || ans[i] <= ans[j])
                array[k] = ans[i++];
                //左边比右边大，答案增加
            else{
                array[k] = ans[j++];
                // 统计逆序对
                count += mid - i + 1;
            }
        }
        return count %mod;
    }
}

