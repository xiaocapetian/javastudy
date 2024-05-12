package leetcode;

public class l50_1 {
    //快速幂，迭代
    //真的很难理解！！--从二进制角度终于理解了!
    public static void main(String[] args) {
        System.out.println(myPow(2,19));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return n>=0?quickMul(x,N):1/quickMul(x,-N);
    }

    public static double quickMul(double x, long n) {
        double xc = x;
        double ans = 1.0;
        while (n>0){
            //xc只会是x的次方 x^(2^0) x^(2^1) x^(2^2)
            System.out.println("x contribute xc= "+xc+", n = "+n);
            if(n%2==1){
               //看n在二进制这位是1还是0,
                //如果是1,那么
                ans = xc * ans;
                System.out.println("ans= "+ans);
            }
            n=n/2;
            xc = xc*xc;//xc的2次方,   x^(2^m)

        }
        return ans;
    }
}
    /*快速幂的思路看这里（看二进制角度）
      作者：Krahets
      链接：https://leetcode.cn/problems/powx-n/solutions/241471/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
      来源：力扣（LeetCode）



     */