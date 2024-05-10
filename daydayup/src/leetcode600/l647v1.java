package leetcode600;

public class l647v1 {
    public int countSubstrings(String s) {
        char[] sarr = s.toCharArray();
        boolean[][] bp = new boolean[sarr.length][sarr.length];
        int res = 0;
        //bp[i][j]是从i开始到j止是否是回文子串
        for (int j = 0;j<s.length();j++){
            for (int i = 0;i<=j;i++){ /*[易错]👇这里考虑清楚*/
                //for (int i = j;i<s.length();i++){
                if(i==j){bp[i][i] = true;}
                else if(i==j-1){
                    if(sarr[i]==sarr[i+1]){bp[i][i+1] =true;}

                }else {
                    if(sarr[i]==sarr[j]&& bp[i + 1][j - 1]){bp[i][j] = true;}
                }

                if(bp[i][j])res++;
            }
        }
        return res;
    }
}
