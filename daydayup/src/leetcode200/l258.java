package leetcode200;

/**
 * 这题别中计了
 * 538你5+3+8就复杂了
 * 应该53+8 再这样下去
 */
public class l258 {

    public int addDigits(int num) {

        while (num%10!=0){
            num = num/10+num%10;
        }
        return num;
    }

    /**
     *真秀啊
     */
    public int addDigits2(int num) {
        if(num%9!=0)return num%9;
        else if(num==0){return 0;}
        else {
            return 9 ;
        }
    }
}
