package 算法.回溯;

import java.util.*;
//有重复项数字的全排列
//https://www.nowcoder.com/practice/a43a2b986ef34843ac4fdd9159b69863
public class Nc_allOrder {
        //用于标记是否访问过
        boolean[] mark;

        public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
            //存储总的返回结果集
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            //存储一个合法全排列
            LinkedList<Integer> track = new LinkedList<>();

            mark = new boolean[num.length];
            //因为存在重复项，为了更好的处理，将数组先排序
            Arrays.sort(num);

            backtrack(num, res, track);

            return res;
        }

        public void backtrack(int[] num, ArrayList<ArrayList<Integer>> res, LinkedList<Integer> track) {
            //若 找到一个全排列，则将它加进结果集中，然后返回(回溯)
            if (track.size() == num.length) {
                res.add(new ArrayList<Integer>(track));
                return;
            }
            for (int i = 0; i < num.length; i++) {
                // 当此时的被访问过
                // 当i>0 &&此时的数等于它的上一个&&上一个没访问过(没访问过证明是回溯后将前面的置为false，所以此时避免重复得用 !mark[i-1] 满足要求然后跳过该数字)
                // arr[1,1,1,2,3]
                // 1,1,1  1,1,2 1,1,3  前面两次回溯得到三个结果
                // 接下来再进行回溯，此时mark[1]被置为false
                // 此时按道理应该遍历到arr[2]这个位置
                // 1,arr[2] 然后后面再加进去，但是我们发现arr[2]==arr[1]，并且此时mark[1]==false
                // 证明它的已经访问过然后回溯的，所以我们跳过arr[2],直接从1,arr[3]开始
                // 也就是说此时得到全排列的结果将会是 1,2,1 1,2,3 而不再是 1,1 ··· 这些重复的了
                if (mark[i] || i > 0 && num[i] == num[i - 1] && !mark[i - 1]) {
                    continue;
                }
                //添加进全排列数组中
                track.add(num[i]);
                //标记为已经访问
                mark[i] = true;
                //继续寻找下一个数
                backtrack(num, res, track);
                //将上一次全排列的结果中，最后一个数移除掉
                track.removeLast();
                //移除掉的数置为 未访问
                mark[i] = false;
            }
        }
    }

