package leetcode;

public class l50 {
    //快速幂，递归,递归是看不懂的,直接下一章看迭代去
    public static void main(String[] args) {
        System.out.println(myPow(3,18));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return n>=0?quickMul(x,N):1/quickMul(x,-N);
    }
    public static double quickMul(double x, long n){
        //我想求x的n次方
        System.out.println("n = "+n+" Before recursion");
        if(n==0)return 1;//家人们太神奇了，这里的n==0不止是预防输入0次幂啊！，随着递归，最终n会等于0，那么返回一个1，
         // 终止递归，回到上一层（n==1的时候）执行递归之后的语句
        double y = quickMul(x, n/2);
        System.out.println("n = "+n+" after recursion");
        System.out.println("y = "+y);
        if(n%2==0)System.out.println("n%2==0此时要返回y*y="+y*y);
        if(n%2!=0)System.out.println("n%2!=0此时要返回y*y*x="+y*y*x);
        return n%2==0?y*y:y*y*x;//当n==1时，（此时y==1,这时候乘一个x,也是第一个x），此后遇到y是单数也要补一个x
        //补进去的x就会进入y中
    }
}
