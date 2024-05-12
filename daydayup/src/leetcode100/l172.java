package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l172 {
    /**
     * 瞧瞧这个写法多么简单!!!一定要学这个啊
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            res+=n/5;
            n /=5;
        }
        return res;
    }

    /**
     * 根据v1的改进版,太麻烦了
     */
    public int trailingZeroes2(int n) {
        int jie=1;
        //int jieshu = 0;
        List<Integer> list =new ArrayList<>();
        while (jie<n){
            jie*=5;
            //jieshu++;
            list.add(jie);//list = {5,25,125,625,3125}
        }
        int[] shang = new int[list.size()];
        int qiansum = 0;
        int res = 0;
        for (int i = 0; i < shang.length; i++) {
            shang[i] = n/list.get(list.size()-1-i)-qiansum;
            qiansum+=shang[i];
            res+=shang[i]*(list.size()-i);
        }
        return res;
    }
    //这样写多傻哦
    public int trailingZeroes1(int n) {

        //3125 5^5  625 5^4 125 5^3
        //int yu = n%10;
        int shang3125 = n/3125;
        int shang625 = n/625-shang3125;
        int shang125 = n/125-shang3125-shang625;
        int shang25 = n/25-shang3125-shang625-shang125;
        int shang5 = n/5-shang3125-shang625-shang125-shang25;

        int res = shang3125*5+shang625*4+shang125*3+shang25*2+shang5 ;
        return res;
    }
}
