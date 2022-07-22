package newCoder101.堆栈队列;

import java.util.ArrayList;
import java.util.Arrays;

public class BM46最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list =new ArrayList<>();
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }


}
