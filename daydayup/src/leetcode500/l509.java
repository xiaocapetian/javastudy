package leetcode500;

public class l509 {
    //按照定义自己写的,,还是看v1动态规划吧
    public int fib(int n) {

        if(n==0)return 0;
        if(n==1)return 1;
        return fib(n-1)+fib(n-2);
    }
}
