package leetcode;

public class l29_1 {
    public static void main(String[] args) {
        //System.out.println(divide(-2147483648,-1));
        //System.out.println(divide(2147483647,1));
        //System.out.println(quickadd(3,5));
        //System.out.println(divide(10,3));
        System.out.println(divide(8,3));
    }
    //尝试自己写二分法查找！
    public static int divide(int dividend, int divisor) {
        int shang = 0;
        int fuhao = 1;
        if (dividend==0)return 0;
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))fuhao = -1;
        int X = dividend>=0?-dividend:dividend;    //被除数  变成-8
        int Y = divisor>=0?-divisor:divisor;   //除数   变成-3
        //为了那个倒霉的MIN_VALUE，全转成负数来计算
        // Z×Y≥X>(Z+1)×Y   寻找Z，    Y=3
        //  2*-3>=-8>3*-3   找Z=2
        //  4*-2>=-8>4*-3
        //int left = 0;int right = 100;
        int left = 0;int right = Integer.MAX_VALUE;
        //int left = Integer.MIN_VALUE,right = 0;
        //二分法查找Z
        while(left<right){
            int mid = (left+right)/2;
            System.out.println(" left= "+left+" right= "+right);
            System.out.println(" Y= "+Y+" mid= "+mid);
            //if(quickaddCheck(mid,Y,X)){return mid;}
            if(quickaddCheck(mid,Y,X)){
                //left = mid + 1;
                right = mid -1;
                System.out.println("right");
            }else{
                //right = mid - 1;
                left = mid +1;
                System.out.println("left");
            }

        }
        return right;

        //return 0;
    }
    public static int quickadd(int Z,int Y){//快速加，替代乘法，算Z个Y相加，Y+Y+++Y
        // 这个写的是对的，但是在那个该死的二分法，结果会溢出，我抄
       int result = 0;int res = 0;
       if (Z==0)return 0;
       res = quickadd(Z/2,Y);
       result = Z%2==0?res+res:res+res+Y;
       return result;
    }
    public static boolean quickaddCheck(int Z,int Y,int X){//快速加，替代乘法，算Z个Y相加，Y+Y+++Y
        //想把比较也塞进去，就不能递归了,我抄
        // Z×Y≥X>(Z+1)×Y   寻找Z，    Y=3
        int result = 0;int res = 0;
        int y_contribute = 0;
        while (Z!=0){
            if(Z/2==0){}
        }

        return true;
    }
}
