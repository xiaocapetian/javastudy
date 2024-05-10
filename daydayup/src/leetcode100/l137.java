package leetcode100;

public class l137 {
    public int singleNumber(int[] nums) {

        int res=0;
        //对于二进制的每一位分别处理 , 假设有32位
        for(int i = 0 ; i<32;i++){
            int total=0;
            for (int num : nums) {
                total = total+(num >> i & 1);//i==0时,取的是最右1位 ,  i 即从右往左第i位
            }
            if(total%3!=0){//说明在这一位有
                res |= (1<<i);
                //res怎么来的,从右往左写的,如果total%3!=0,就说明这i位是1,
                //把1往左移动i位
            }
        }
        return res;
    }
}
