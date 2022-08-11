package newCoder101.字符串;

public class BM84最长公共前缀 {
        /**
         *
         * @param strs string字符串一维数组
         * @return string字符串
         */
        public String longestCommonPrefix (String[] strs) {
            // //纵向扫描
            if(strs.length==0 || strs==null){
                return "";
            }
            int rows = strs.length;
            int cols = strs[0].length();

            //开始扫描
            for(int i=0;i<cols;i++){
                char firstChar = strs[0].charAt(i);
                for(int j=1;j<rows;j++){
                    if(strs[j].length()==i || strs[j].charAt(i)!=firstChar){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return strs[0];
        }
    }

