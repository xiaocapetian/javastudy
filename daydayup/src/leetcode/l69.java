package leetcode;

public class l69 {
    public static void main(String[] args) {
        //mySqrt2(2147395599);
        System.out.println("========");
        //mySqrt3(2147395599);
    }
    /**
     * 我的二分查找怎么就超时了
     * [易错]问题出在这里int mid = left+(right-left)/2;
     * [易错]以及这里(long)mid*mid==x
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left<=right){
            int mid = left+(right-left)/2;
            if((long)mid*mid==x){return mid;}
            else if((long)mid*mid<x){
                left = mid+1;
            }else {
                right = mid-1;
            }
            System.out.println("left"+left+"right"+right);
        }
        return left-1;
    }

    /**
     * 人家这个二分查找怎么就对啊
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            System.out.println("left"+l+"right"+r);
        }
        return ans;
    }

    /**
     * 自己想的这个缩小范围不对,反而更慢
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        String sxtr = x+"";
        int wei = sxtr.length();
        int genwei = wei%2==0?wei/2:wei/2+1;
        int start = 1;
        for (int i = 1; i < genwei; i++) {
            start = start*10;
        }
        int left = start;

        int right = start*10-1;
        System.out.println(left);
        while (left<=right){
            int mid = (left+right)/2;
            if(mid*mid==x){return mid;}
            else if(mid<=x/mid){/*[易错1]这里可能会超过int范围,故要移过来mid<=x/mid
            [易错2]<要换成<=*/
                left = mid+1;
            }else {
                right = mid-1;
            }
            //System.out.println("left"+left+"right"+right);
        }
        return left-1;
    }




}
/*
 * left0right4
 * left3right4
 * left4right4
 * left4right3
 *
 * left0right4
 * left3right4
 * left4right4
 * left4right3
 */