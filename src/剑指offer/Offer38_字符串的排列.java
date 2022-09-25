package 剑指offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Offer38_字符串的排列 {

    List<String> list =new LinkedList<>();
    char[] chars;
    public String[] permutation(String s) {
        chars =s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    //深度优先遍历
    private void dfs(int x) {
        if (x==chars.length-1){
            //已经遍历到最后的位置，直接加入到结果集中
            list.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set =new HashSet<>();
        for (int i = x; i < chars.length ; i++) {
            //存在重复路径，剪枝
            if (set.contains(chars[i])){
                continue;
            }
            set.add(chars[i]);
            swap(i,x);              //开启交换，将c[i]固定在x位置
            dfs(x+1);           //开始固定第x+1位元素
            swap(i,x);              //恢复交换
        }
    }
    //交换位置
    private void swap(int i, int x) {
        char temp =chars[i];
        chars[i] =chars[x];
        chars[x] =temp;
    }
}
