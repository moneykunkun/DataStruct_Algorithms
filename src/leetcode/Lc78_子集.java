package leetcode;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Lc78_子集 {

    /**
     * 递归解法
     * 首先将空集加入到子集中，因为空集是任意集合的子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result =new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> sub =new ArrayList<>();
            for (List<Integer> cur :result){
                //复制原子集中元素加入到新的元素
                List<Integer> newSub =new ArrayList<>(cur);
                newSub.add(num);
                sub.add(newSub);
            }
            result.addAll(sub);
        }
        return result;
    }
}
