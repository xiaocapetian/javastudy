package leetcode500;

public class l541v1 {
    public String reverseStr(String s, int k) {
        char[] sarr = s.toCharArray();

        for(int i = 0;i<s.length();i+=2*k){
            reverseString(sarr,i, Math.min(i+k-1,s.length()));
            /*这题要复用函数呀!!!!*/
//这个仔细看很有意思,整2k前的部分和 结尾情况一合并了  ,再和结尾情况二取最小值就三合一了
        }
        return new String(sarr);
    }
    public void reverseString(char[] s,int left, int right) {
        //int left = 0;
        //int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }


}
