package leetcode200;

public class l263 {
    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     * @param n 给你一个整数 n ，请你判断 n 是否为 丑数
     * @return 如果是，返回 true ；否则，返回 false 。
     */
    public boolean isUgly(int n) {
        if(n<=0)return true;
        while (n%30==0){
            n=n/30;
        }
        while (n%10==0){
            n = n/10;
        }
        while (n%6==0){
            n = n/6;
        }
        while (n%15==0){
            n = n/15;
        }
        while (n%5==0){
            n = n/5;
        }
        while (n%2==0){
            n = n/2;
        }
        while (n%3==0){
            n = n/3;
        }
        return n==1;
    }
}
