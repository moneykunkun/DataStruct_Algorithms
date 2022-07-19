package newCoder101;

import java.util.Scanner;
//排序子序列
// 链接：https://www.nowcoder.com/questionTerminal/2d3f6ddd82da445d804c95db22dcc471?source=relative
//来源：牛客网
//牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
//如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2
public class Nc_sortStr {
        public static void main(String[] args) {
            Scanner in =new Scanner(System.in);
            int len = in.nextInt();
            int[] arr =new int[len+1];
            int index =0;
            while (in.hasNext()){
                arr[index++] =in.nextInt();
            }
            int res =minGroup(arr,len);
            System.out.println(res);
        }

        private static int minGroup(int[] arr, int len) {
            int count =0;
            int index=0;      //记录数组的下标
            if (len<=2){
                return 1;
            }
            for (  ; index <len;index++ ){
                if (arr[index+1]==arr[index]){
                    continue;
                }else if (arr[index] < arr[index+1]){
                    while (index < len && arr[index] <= arr[index+1]){
                        index++;
                    }
                    count++;
                }else if (arr[index] > arr[index+1]){
                    while (index <len && arr[index] >= arr[index+1]){
                        index++;
                    }
                    count++;
                }
            }
            return count;
        }
    }
