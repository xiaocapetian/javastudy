package leetcode600;

public class l647 {
    public int countSubstrings(String s) {
//dp[i][j]代表从第i位到第j位字串的数目   我自己想的是这个,
        //但是老师讲的是 dp[j][i]代表从第i位到第j位字串是不是回文串  //这和l5一模一样啊
        char[] sarr = s.toCharArray();
        boolean[][] bp = new boolean[sarr.length+1][sarr.length+1];
        //bp[0][0] = true;  这个不用
        int res = 0;
        for(int i = 1;i<=sarr.length;i++){
            for(int j = 1;j<=i;j++){
                //如果只有1位
                if(i==j){bp[j][i]=true;}
                //如果只有2位
                else if(i==j+1){bp[j][i]=(sarr[j-1]==sarr[i-1]);}
                //3位或者以上,首位相等时看中间是否是回文模拟,状态转移了吧
                else if(sarr[i-1] == sarr[j-1]) {
                        bp[j][i] = bp[j + 1][i - 1];
                    }
                if (bp[j][i]) {
                    res++;
                }
            }
        }
//        for(int i = 0;i<sarr.length;i++){
//            for(int j = 0;j<sarr.length;j++){
//                System.out.print(bp[j][i]+",");
//            }
//            System.out.println();
//        }
        return res;

    }
}
