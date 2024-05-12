package leetcode;

/**
 * 这题吧能做出来,但是修改太多,,
 * [重点]:'*'还可以干掉前面那位
 */
public class l10 {
    public boolean isMatch(String s, String p) {

        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;
        for(int i =1;i<p.length()+1;i++){
            if(parr[i-1]=='*'){dp[i][0]=dp[i-2][0];}//初始化的时候记得了,*可以干掉上一位,还真可能匹配上""
        }
        for(int i =1;i<p.length()+1;i++){
            for(int j = 1;j<s.length()+1;j++){
                if(parr[i-1]=='.'){
                    //dp[i][j]
                    dp[i][j]=dp[i-1][j-1];
                }else if(parr[i-1]=='*'){
                    if(dp[i-1][j]||dp[i-2][j]){//如果正上方是true,不用*这一位就符合,那*可以代表1个
                        //如果正上方两位是true,那*可以干掉前一位,代表0个
                        dp[i][j]=true;
                    }else {
                        if(dp[i][j-1]){//如果左边是true,且p是连续相等,那也可以
                            if(parr[i-2]=='*'||parr[i-2]=='.'){
                                dp[i][j] = true;
                            }
                            else {
                                if(sarr[j-1]==parr[i-2]){
                                    //parr[i-2]是*要模仿的那一位
                                    /*[易错]要👆这样写,👇这样是不可以哒,ab*a和aaa,*是用来干掉b的,直接判断*修饰的那一位是否和s匹配就好了*/
                                //if(j-2>=0&&sarr[j-2]==sarr[j-1]){
                                    dp[i][j] = true;
                                }
                            }

                        }
                    }
                }else {
                    if(parr[i-1]==sarr[j-1]){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }

            }
        }
        return dp[p.length()][s.length()];
    }
}
