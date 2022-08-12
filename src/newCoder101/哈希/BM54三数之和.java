package newCoder101.哈希;

import java.util.ArrayList;
import java.util.Arrays;

public class BM54三数之和 {


    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //存放最终结果的集合
    ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
    int len =num.length;
    //长度小于3不满足条件
    if (len<3){
      return ans;
    }
        Arrays.sort(num);
        for (int i = 0; i <len ; i++) {
            //如果num[i]>0,不满足
            if (num[i]>0){
                return ans;
            }
            if (i>0 && num[i] ==num[i-1]){
                continue;
            }
            //声明指针
            int cur=num[i];
            int left=i+1;
            int right=len-1;
            while (left<right){
        //满足条件的3元素
                int result =cur+num[left]+num[right];
                if (result ==0){
                    //找到集合
                    ArrayList<Integer> res =new ArrayList<>();
                    res.add(cur);
                    res.add(num[left] );
                    res.add(num[right]);
                    //将最终答案存入集合
                    ans.add(res);
                    //判断指针两侧的数据是否重复
                    while (left<right && num[left] ==num[left+1]){
                        left++;
                    }
                    while (left<right && num[right] ==num[right-1]){
                        right--;
                    }
                    //移动指针
                    left++;
                    right--;
                }else if (result <0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
