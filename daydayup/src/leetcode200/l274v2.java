package leetcode200;

import java.util.Arrays;

public class l274v2 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i =citations.length-1;
        while (i>=0&&citations[i]>h){
            //想一下第一位h=0; >0说明起码为1,h++;下一轮不符合跳出了那就h=1;
            //               <0说明为0,  返回的也是对的
            h++;
            i--;
        }
        return h;
    }
}
