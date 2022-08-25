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
     * @param begin 搜索起始位置
     * @param len
     * @param target    目标值，没减去一个元素，目标值减小
     * @param path  存储根节点到叶子节点的路径，栈
     * @param res   存储结果集
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
       //目标值小于0，不存在
        if (target< 0){
            return;
        }
        if (target ==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //开始深度优先搜索
        for (int i = begin; i <len ; i++) {
            //每表里一个元素 就加入到路径中
            path.addLast(candidates[i]);

            //元素可以重复使用，因此下次开始遍历的时候仍然从i开始
            dfs(candidates,i,len,target-candidates[i],path,res);
            //状态重置
            //不包含重复项，每次遍历后需要剪枝
            path.removeLast();
        }

    }
}
