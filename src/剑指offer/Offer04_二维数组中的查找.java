package 剑指offer;

public class Offer04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] ==target){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 广度遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int i=matrix.length-1,j=0;
        while (i>=0 && j<matrix[0].length){
            if (matrix[i][j] >target) {
                i--;
            }else  if (matrix[i][j]<target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
