package leetcode;

import java.util.ArrayList;
import java.util.List;

/**杨辉三角问题
 * @author qk
 * @date 2022年03月11日 9:27
 */
public class Lc118_YangHui {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list= new ArrayList<>();
    int[ ][ ]  arr = new int[numRows][numRows];
    for (int i=0;i<numRows;i++){
        List<Integer> subList = new ArrayList<>();
        for (int j = 0; j < i+1; j++) {
            if (j==0 || j==i){
                arr[i][j] = 1;
            }else {
                arr[i][j] = arr[i-1][j-1] +arr[i-1][j];
            }
            subList.add(arr[i][j]);
        }
        list.add(subList);
    }
    return list;
    }

    public static void main(String[] args) {
     Lc118_YangHui yangHui =new Lc118_YangHui();
     yangHui.generate(5);
    }

}
