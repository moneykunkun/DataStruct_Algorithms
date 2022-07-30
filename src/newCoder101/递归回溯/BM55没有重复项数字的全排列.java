package newCoder101.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;

public class BM55没有重复项数字的全排列 {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        //1.先将数组排序
        Arrays.sort(num);
        //2.创建集合
        ArrayList<ArrayList<Integer>> res =new ArrayList<>();
        ArrayList<Integer> cur =new ArrayList<>();
            //将数组转为集合
        for (int i = 0; i < num.length; i++) {
            cur.add(num[i] );
        }
        recursion(res,cur,0);
        return res;
    }

    /**
     * 递归
     * @param res
     * @param cur
     * @param index
     */
    private void recursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int index) {
        //分支走到结尾，存储当前路径
        if(index ==cur.size()-1){
            res.add(cur);
        }else {
            //分支还未走到结尾，继续后面的遍历
            for (int i = index; i <cur.size() ; i++) {
            //交换元素的位置
                swapNum(cur,i,index);
                //继续递归到下一个位置
                recursion(res,cur,index+1);
                //回溯
                swapNum(cur,i,index);
            }
        }

    }

    /**
     * 交换集合中元素的位置
     * @param cur
     * @param i1
     * @param i2
     */
    private void swapNum(ArrayList<Integer> cur, int i1, int i2) {
        int tmp =cur.get(i1);
        cur.set(i1,cur.get(i2));
        cur.set(i2,tmp);
    }
}
