package leetcode100;

public class l191 {
    public int hammingWeight(int n) {

        int res = 0;
        while (n!=0){

            if((n&1)==1){
                res++;
            }
            n = n>>1;
        }
        return res;
    }
}
