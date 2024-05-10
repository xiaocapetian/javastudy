package leetcode400;

public class l409 {
    public int longestPalindrome(String s) {

//        int[] num = new int[52];
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)<='z'&&s.charAt(i)>='a'){num[s.charAt(i)-'a']++;}
//            if(s.charAt(i)<='Z'&&s.charAt(i)>='A'){num[s.charAt(i)-'A'+26]++;}          /*-'A'怎么写成-'a'了*/
//        }
        //其实👇这样不用计算比👆更快一点
        int[] num = new int[128];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)]++;
        }

        int res = 0;
        boolean hasJi = false;
        for (int i = 0; i < num.length; i++) {

            if(num[i]%2==1){
                hasJi=true;
                res+=num[i]-1;/*单数也要加,别漏了啊*/
            }
            else {
                res+=num[i];
            }
        }
        return hasJi?res:res+1;/*这也能写反?*/
    }

}
