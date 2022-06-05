package 数据结构.队列.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//杨辉三角问题
public class Lc118_yangHui {
    //解法1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        int[][] arr=new int[numRows][numRows];
        for(int i=0;i< numRows;i++){
            List<Integer> subList=new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        return list;
    }

    //解法2
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ret =new ArrayList<>();
        //第一行
        List<Integer> fir = Arrays.asList(1);
        ret.add(fir);
        if (numRows ==1){
            return ret;
        }
        //第二行
        List<Integer> sec =Arrays.asList(1,1);
        ret.add(sec);
        if (numRows==2){
            return ret;
        }
        //此时numRows >=3
        for (int i = 3; i <=numRows ; i++) {
            //先取得前一行的元素
            List<Integer> prev =ret.get(i-1-1);         //注意 i-1表示i位置的索引
            List<Integer> cur =new ArrayList<>();       //存储当前行的元素
            //每一行的第一个和最后一个元素都是1
            cur.add(1);
            //从第二列开始到倒数第2列，添加元素
            for (int j = 2; j <i ; j++) {
                //递推公式，[i,j] =[i-1,j-1]+[i-1,j]
                int tempValue =prev.get(j-1-1)+prev.get(j-1);
                cur.add(tempValue);
            }
            //每一行最后的元素也是1
            cur.add(1);
            ret.add(cur);
        }
        return ret;
     }

}
