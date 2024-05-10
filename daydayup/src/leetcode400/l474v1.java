package leetcode400;

public class l474v1 {
    //一维数组压缩版
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] bp = new int[m+1][n+1];
        for (int i = 0;i<strs.length;i++){
            int oneNum = 0, zeroNum = 0;
            for (char c : strs[i].toCharArray()) {
                if(c=='0'){zeroNum++;}else {oneNum++;}
            }
            //对于一维数组,01背包记得倒序,什么时候停呢, j>=zeroNum那bp[j-zeroNum]都越界了,也就是这一个物品比整个背包还大当然就停啦
            for (int j = m;j>=zeroNum;j--){
                for(int k = n;k>=oneNum;k--){

                    //if(j-zeroNum>=0&&k-oneNum>=0){
                    bp[j][k] = Math.max(bp[j][k],bp[j-zeroNum][k-oneNum]+1);
                    //}else {bp[j][k] = bp[j][k];}
                }
            }
        }
        return bp[m][n];
    }
}
