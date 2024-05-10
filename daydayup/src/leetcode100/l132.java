package leetcode100;

import java.util.Arrays;

/**
 * [难点]第一次动规得一个bp
 * [难点2]再次动规.一维的f[]    f[i]是从0->i最小的切割次数
 *
 * 【易错1】
 * 【易错2】
 */
public class l132 {
    public int minCut(String s) {
        int res=0;
        char[] sarr = s.toCharArray();
        boolean[][] bp = new boolean[sarr.length][sarr.length];
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
            }
        }

        //再次动规
        int[] f = new int[s.length()];
        Arrays.fill(f, f.length);
        for (int i = 0;i<s.length();i++){
            if(bp[0][i])f[i]=0;/*【易错1】如果直接就是子串不用加了*/
            else {
                for (int j = i-1;j>=0;j--){//派出一个j从后往前
                    if(bp[j+1][i]){/*【易错2】这里是 bp[j+1][i] */
                        f[i] =Math.min(f[i] ,(f[j]+1));}
                }
            }
            System.out.println(Arrays.toString(f));
        }
        res = f[f.length-1];
        return res;
    }
}


/*        应该斜着搞bp但是感觉很复杂
        int i = 0;
        for(int k = 0;;k++){
            //int i =
            //i从 0->k  j len-1-k  ->  len-1
            for(int )
        }*/


        /*这样横着搞bp是不对的
        for (int j = s.length()-1;i<s.length()&&j>=0;){
            System.out.println(bp[i][j]);
            if(bp[i][j]){
                System.out.println("i="+i+" s.length()-1="+(s.length()-1));
                *//*[易错]这里最后一刀不能切]*//*
                if(j!=s.length()-1)res++;
                i=j+1;
                j=s.length()-1;

            }else {
                j--;
            }
        }*/

