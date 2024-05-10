package leetcode100;

public class l190 {
    /**
     * @param n 给定的 32 位无符号整数的二进制位
     * @return 颠倒
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //n从最后一位开始往前读,那res就从第一位往后写
            res=(res<<1)|(n&1);
            n = n>>1;
            System.out.println(Integer.toBinaryString(res));
        }
        return res;
    }
}
