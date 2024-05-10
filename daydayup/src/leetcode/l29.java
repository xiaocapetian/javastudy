package leetcode;

public class l29 {
    public static void main(String[] args) {
        //System.out.println(divide(-2147483648,-1));
        System.out.println(divide(2147483647,1));

    }
    //自己写的，基本是对的，但是超时了，应该用二分法查找
    public static int divide(int dividend, int divisor) {
         int shang = 0;
         int fuhao = 1;
         if (dividend==0)return 0;
         if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))fuhao = -1;

         if(dividend==Integer.MIN_VALUE){
             if(divisor==1){return Integer.MIN_VALUE;}
             if(divisor==-1){return Integer.MAX_VALUE;}
             shang = 1;
             int jianshu = divisor>=0?divisor:-divisor;
             int cha = -(dividend + jianshu);
             while (cha-jianshu>=0){
                 cha = cha - jianshu;
                 shang++;

             }
             return shang*fuhao;
         }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }


         int cha = dividend>=0?dividend:-dividend;
         int jianshu = divisor>=0?divisor:-divisor;
         while (cha-jianshu>=0){
             cha = cha - jianshu;
             shang++;
         }
         return shang*fuhao;
    }
}
