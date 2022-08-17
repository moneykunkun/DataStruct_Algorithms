package newCoder101.排序;

import java.util.ArrayList;

public class BM48数据流中的中位数 {

    /**
     * Insert()方法读取数据流
     * @param num
     * nlogn  插入排序
     */
    private ArrayList<Integer>  list =new ArrayList<>();
    public void Insert(Integer num) {
        if (list.isEmpty()){
            //集合中没有元素，直接插入
            list.add(num);
        }else {
            //集合中有元素，需要找到待插入的位置
            int i=0;
            for (;  i<list.size() ; i++) {
                if (num<+list.get(i)){
                    break;
                }
            }
            //插入相应位置
            list.add(i,num);
        }
    }

    /**
     * GetMedian()方法获取当前读取数据的中位数
     * @return
     */
    public Double GetMedian() {
        int n=list.size();
        if (n%2==1){
            //奇数个，直接返回中间值
            return (double)list.get(n/2);
        }else {
            //偶数个，需要求中将两个数的平均数
            double a =list.get(n/2);
            double b =list.get(n/2-1);
            return (a+b)/2;
        }
    }
}
