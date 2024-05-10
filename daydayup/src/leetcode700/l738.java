package leetcode700;

import java.util.ArrayList;
import java.util.List;

public class l738 {
    //这是我自己写的
    public int monotoneIncreasingDigits(int n) {

        List<Integer> num = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        //这一段太复杂!
        int nn = n;
        while (nn/10!=0){
            num.add(nn%10);
            nn=nn/10;
        }
        num.add(nn);
        //直接这样多好,  String s = String.valueOf(n);
        //            char[] chars = s.toCharArray();

        //System.out.println(num);
        res.add(num.get(num.size()-1));
        boolean not99Yet = true;
        for (int i = num.size()-2; i >=0; i--) {//这个for循环我的思路是一致的,但是我写的太复杂了
            if(num.get(i+1)<=num.get(i)&&not99Yet){//递增没有问题
                res.add(num.get(i));}
            else if(not99Yet){//尴尬了,往前循环吧
                res.add(num.get(i));
                for (int index= res.size()-2;index>=0&&res.get(index)>res.get(index+1);index--){//后一位小于前一位
                    res.set(index+1,9);
                    res.set(index,res.get(index)-1);
                }
                not99Yet = false;

            }
            else {res.add(9);}
        }
        int result = 0;
        //System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            result = result*10+res.get(i);
        }
        return result;
    }
}
