package leetcode200;

import java.util.Arrays;

/**
 * 多路归并（多指针）
 */
public class l264v1 {
    public int nthUglyNumber(int n) {

        int[] res =new int[n+1];
        res[1] = 1;
        for(int i2 =1,i3=1,i5=1,i=2;i<n+1;i++){
            int z2 = res[i2]*2;
            int z3 = res[i3]*3;
            int z5 = res[i5]*5;
            int min =Math.min(z2,Math.min(z3,z5));
            res[i] = min;
            if(min==z2){i2++;}
            if(min==z3){i3++;}
            if(min==z5){i5++;}
            //i++;
            /*[易错]👆你激动啥啊??*/
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }
}
//        作者：宫水三叶
//                链接：https://leetcode.cn/problems/ugly-number-ii/solutions/714340/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
//                来源：力扣（LeetCode）
//                著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。