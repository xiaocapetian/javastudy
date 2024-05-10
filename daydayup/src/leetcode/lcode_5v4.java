package leetcode;

/**
 * v4再刷l5,这次一遍过了 v3的问题看来都掌握了
 * l131的其中一步
 */
public class lcode_5v4 {
    public String longestPalindrome(String s) {

        char[] sarr = s.toCharArray();
        int[][] bp = new int[s.length()][s.length()];
        int max=0;
        int maxi=0;
        int maxj=0;

        //bp[i][j]是从i开始到j止是否是回文子串
        for (int j = 0;j<s.length();j++){
            for (int i = 0;i<=j;i++){ /*[易错]👇这里考虑清楚*/
                //for (int i = j;i<s.length();i++){
                if(i==j){bp[i][i] = 1;}
                else if(i==j-1){
                    if(sarr[i]==sarr[i+1]){bp[i][i+1] = 2;}

                }else {
                    if(sarr[i]==sarr[j]&&bp[i+1][j-1]!=0){bp[i][j] = bp[i+1][j-1]+2;}
                }
                if(bp[i][j]>max){
                    max = bp[i][j];
                    maxi=i;
                    maxj=j;
                }
            }
        }
        return s.substring(maxi,maxj+1);
    }
}
