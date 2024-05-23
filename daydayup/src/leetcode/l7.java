package leetcode;

public class l7 {
    public int reverse(int x) {

        boolean iszheng = false;
        if(x>=0){iszheng =true;}
        else {x = -x;}
        int res = 0;
        while (x>0){
            int wei = x%10;
            if(res<Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&wei<=Integer.MAX_VALUE%10)){
                /*[易错]这里要分开||  比如最大值是32165 要么是小于,如3214   只有在等于3215的话,才要比最后一位*/
                res = res*10+wei;
            }else {return 0;}/*[易错]看清楚返回要求*/

            x = x/10;

        }
        return iszheng?res:-res;
    }
}
