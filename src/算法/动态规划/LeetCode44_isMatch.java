package 算法.动态规划;
//字符串匹配
public class LeetCode44_isMatch {
        public boolean isMatch(String s, String p) {
            boolean[][] table =new boolean[s.length()+1][p.length()+1];
            //空空字符串匹配
            table[0][0]=true;
            for (int i = 1; i <table[0].length ; i++) {
                if (p.charAt(i-1)=='*'){
                    //如果p字符是*，就看字符串的前一个是否匹配
                    table[0][i]=table[0][i-1];
                }
            }
            for (int row = 1; row <table.length ; row++) {
                char s1=s.charAt(row-1);
                for (int col = 1; col <table[row].length ; col++) {
                    char p1=p.charAt(col-1);
                    if (s1==p1 || p1=='?'){
                        table[row][col] =table[row-1][col-1];
                    }else if (p1=='*'){
                        table[row][col] =table[row][col-1] || table[row-1][col];
                    }
                }
            }
            boolean[] lastRow =table[table.length-1];
            return lastRow[lastRow.length-1];
        }
    }

