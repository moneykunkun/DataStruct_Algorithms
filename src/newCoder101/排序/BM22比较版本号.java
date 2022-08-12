package newCoder101.排序;

public class BM22比较版本号 {

    public int compare (String version1, String version2) {
        // write code here
        int n1 =version1.length();
        int n2 =version2.length();
        int i=0,j=0;
        //直到某个字符串结束
        while (i<n1 || j<n2){
            long num1=0;
            //从下一个点前截取数组
            while (i<n1 && version1.charAt(i) !='.'){
                num1 =num1*10+(version1.charAt(i)-'0');
                i++;
            }
            //跳过点
            i++;
            long num2=0;
            while (j<n2 && version2.charAt(j) !='.'){
                num2 =num2*10+(version2.charAt(j)-'0');
                j++;
            }
            //跳过点
            j++;
            //比较数字大小
            if (num1<num2){
                return -1;
            }
            if (num1>num2){
                return 1;
            }
        }
        return 0;
    }
}
