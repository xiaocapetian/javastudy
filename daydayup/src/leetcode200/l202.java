package leetcode200;

import java.util.HashSet;

public class l202 {
    //看了答案写出来了这种题就记个结论呗
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        int y = n;
        int res=0;
        while (y/10!=0){
            int gewei = y%10;
            res +=gewei*gewei;
            y = y/10;
        }
        res+=y*y;
        if(res==1)return true;
        else if(set.contains(res))return false;
        else {
            set.add(res);
            return isHappy(res);
        }
    }
}
