package leetcode400;

public class l474 {
    public int findMaxForm(String[] strs, int m, int n) {
/*自己写的,三维数组,而且写对了,
重量换成二维的,奇慢无比*/
        int[][][] bp = new int[strs.length][m+1][n+1];
        //先把第一行初始化了
        for (int j = 0;j<m+1;j++){
            for(int k = 0;k<n+1;k++) {
                int oneNum = 0, zeroNum = 0;
                for (char c : strs[0].toCharArray()) {
                    if(c=='0'){zeroNum++;}else {oneNum++;}
                }
                if(zeroNum<=j&&oneNum<=k)bp[0][j][k]=1;
            }
            }
        for (int i = 1;i<strs.length;i++){
            int oneNum = 0, zeroNum = 0;
            for (char c : strs[i].toCharArray()) {
                if(c=='0'){zeroNum++;}else {oneNum++;}
            }
            for (int j = 0;j<m+1;j++){
                for(int k = 0;k<n+1;k++){

                    if(j-zeroNum>=0&&k-oneNum>=0){
                    bp[i][j][k] = Math.max(bp[i-1][j][k],bp[i-1][j-zeroNum][k-oneNum]+1);}
                    else {bp[i][j][k] = bp[i-1][j][k];}
                }
            }
        }
        return bp[strs.length-1][m][n];
    }


}
