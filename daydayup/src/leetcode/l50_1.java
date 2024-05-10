package leetcode;

public class l50_1 {
    //快速幂，迭代
    //真的很难理解！！
    public static void main(String[] args) {
        System.out.println(myPow(2,18));
    }
    public static double myPow(double x, int n) {
        long N = n;
        return n>=0?quickMul(x,N):1/quickMul(x,-N);
    }
    public static double quickMul(double x, long n) {
        double x_contribute = x;
        double ans = 1.0;
        while (n>0){
            if(n%2==1){
                ans = x_contribute * ans;
                System.out.println("ans= "+ans);
            }
            n=n/2;
            x_contribute = x_contribute*x_contribute;
            System.out.println("x_contribute= "+x_contribute);
        }
        return ans;
    }
}
