package 技术笔试;

public class GLD_跳跃游戏2 {

    public int jump(int[] nums) {
        int n= nums.length;
        int end =0;
        int maxIndex =0;        //最远可达的位置
        int steps =0;       //跳跃的的步数
        //题目假设最后位置永远可达，那么最后到达最后位置那一步可以不算
        for (int i = 0; i < n-1; i++) {
            maxIndex =Math.max(maxIndex,nums[i] +i);
            if (i==end){
                end =maxIndex;
                steps++;
            }
        }
        return steps;
    }
}
