package leetcode200;

import java.util.ArrayList;
import java.util.List;

public class l201 {
    /**这题要想到实际上求的是left和right所有数的公共前缀
     * 但是要简化成求left和right的公共前缀
     * 而只要在left和right直接,肯定有相同的公共前缀
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {

        int leftqQianzhui=left;
        int rightQianzhui=right;
        int weiyiNum = 0;
        while (leftqQianzhui!=rightQianzhui){
            leftqQianzhui = leftqQianzhui>>1;
            rightQianzhui = rightQianzhui>>1;
            weiyiNum++;
        }
        return leftqQianzhui<<weiyiNum;
    }
    /**
     * 还是超时
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAndv2(int left, int right) {
        //2^31 - 1用32位就行
        String leftstr = Integer.toBinaryString(left);
        List<Integer> has1 = new ArrayList<>();
        char[] leftarr = leftstr.toCharArray();
        for (int i = 0; i < leftstr.length(); i++) {
            //if(leftstr.charAt(i)=='1'){
            if(leftarr[i]=='1'){
                has1.add(leftstr.length()-i);//现在我知道这些位是1了
            }
        }
        int cur = left+1;
        while (cur<=right){
            for (int i = 0; i < has1.size(); i++) {
                Integer wei = has1.get(i);
                if((1&(cur>>(wei-1)))==0){
                    has1.remove(i);
                }

            }
            cur++;
        }
        int res=0;
        for (Integer wei : has1) {
            res = res|(1<<(wei-1));
        }
        return res;
    }

    /**
     * 暴力解法肯定是超时的
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAndv1(int left, int right) {

        int cur = left;
        int res = left;
        while (cur<right){
            cur++;
            res = res&cur;
        }
        return res;
    }
}
