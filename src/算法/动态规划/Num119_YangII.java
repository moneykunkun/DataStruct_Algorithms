package 算法.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行
 */
public class Num119_YangII {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        //int[][] nums=new int[rowIndex][rowIndex];
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    subList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(subList);
        }
        return list.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
}
