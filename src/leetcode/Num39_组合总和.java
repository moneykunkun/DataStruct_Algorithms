package leetcode;

import java.util.*;

public class Num39_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len =candidates.length;
        List<List<Integer>> res =new ArrayList<>();
        if (len ==0) return res;
        Deque<Integer> path=new ArrayDeque<>();
        //深度优先遍历
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    /**
     * @param candidates    候选数组
     * @param i
     * @param len
     * @param target
     * @param path
     * @param res
     */
    private void dfs(int[] candidates, int i, int len, int target, Deque<Integer> path, List<List<Integer>> res) {

    }
}
